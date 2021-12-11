package io.hel.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * helei
 * 2021/11/18 11:37
 * description:
 */
@SuppressWarnings("all")
public final class JSR303Util {

    /** 校验器 */
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /** 分号分隔符 */
    private static final String SEMICOLON = ";";

    /**
     * 验证对象不符合规则抛出异常
     *
     * @param target 验证目标对象
     * @throws IllegalArgumentException 验证不通过抛出
     */
    public static void validateThrow(Object target) throws Exception {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target);
        if (constraintViolations != null && !constraintViolations.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 验证对象不符合规则返回是否
     *
     * @param target 验证目标对象
     * @return 是否通过
     */
    public static boolean validateReturn(Object target) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target);
        if (constraintViolations != null && !constraintViolations.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 验证对象不符合规则返回验证信息
     *
     * @param target 验证目标对象
     * @return 通过返回<code>null</code>，不通过返回具体异常信息
     */
    public static String validateMessage(Object target) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target);
        if (constraintViolations != null && !constraintViolations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (ConstraintViolation<Object> cv : constraintViolations) {
                builder.append(cv.getMessage()).append(SEMICOLON);
            }
            return builder.toString();
        }
        return null;
    }
}
