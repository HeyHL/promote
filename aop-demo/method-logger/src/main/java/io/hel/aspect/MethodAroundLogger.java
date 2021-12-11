package io.hel.aspect;

import cn.hutool.json.JSONUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * helei
 * 2021/11/18 11:45
 * description:
 */
@SuppressWarnings("all")
@Aspect
@Component
@Order(Integer.MIN_VALUE + 1)
public class MethodAroundLogger {
    private static final Logger logger = LoggerFactory.getLogger(MethodAroundLogger.class);

    @Around("@within(io.hel.anno.MethodAroundLogger)")
    public Object execute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        String methodName = proceedingJoinPoint.getSignature().getName();
        StringBuilder stringBuilder = new StringBuilder();
        for (Object arg : args) {
            stringBuilder.append(JSONUtil.toJsonStr(arg));
        }
        logger.info("method name->{}, request data->{}", methodName, stringBuilder.toString());
        Object res = proceedingJoinPoint.proceed();
        logger.info("method name->{}, response data->{}", methodName, JSONUtil.toJsonStr(res));
        return res;
    }
}
