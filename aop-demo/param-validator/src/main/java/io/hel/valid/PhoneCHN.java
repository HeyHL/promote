package io.hel.valid;

import io.hel.valid.PhoneCHNValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * helei
 * 2021/11/18 14:41
 * description:
 * 手机号验证-中国大陆
 */
@SuppressWarnings("all")
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PhoneCHNValidator.class})
public @interface PhoneCHN {

    String message() default "手机号格式错误";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
