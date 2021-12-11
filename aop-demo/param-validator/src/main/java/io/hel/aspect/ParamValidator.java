package io.hel.aspect;

import io.hel.enums.aop.ParamStateCode;
import io.hel.excep.BusinessException;
import io.hel.util.JSR303Util;
import io.hel.vo.resp.ResultVO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * helei
 * 2021/11/18 11:40
 * description:
 */
@SuppressWarnings("all")
@Aspect
@Component
@Order(Integer.MIN_VALUE)
public class ParamValidator {

    private static final Logger logger = LoggerFactory.getLogger(ParamValidator.class);

    private static final String EMPTY_STRING = "";

    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object execute(ProceedingJoinPoint proceed) throws Throwable {
        logger.info("######ParamValidator.execute");
        Object[] args = proceed.getArgs();
        BindingResult result = null;
        for (int i = 0; i < args.length; i++) {
            Object param = args[i];
            if (param instanceof BindingResult) {
                result = (BindingResult)param;
                break;
            }

            // 判断元素类型
            final String validateResult = JSR303Util.validateMessage(param);
            if (validateResult != null && !EMPTY_STRING.equalsIgnoreCase(validateResult)) {
                logger.info("#######ParamValidAspect.execute.validateResult->{}", validateResult);
                return new ResultVO(ParamStateCode.INVALID.getCode(), validateResult, null);
            }
        }
        if (result != null) {
            if (result.hasErrors()) {
                BusinessException businessException = ParamStateCode.INVALID.toBusinessException();
                return ResultVO.error(ParamStateCode.INVALID.getCode(), result.getFieldError().getDefaultMessage());
            }
        }
        return proceed.proceed();
    }
}
