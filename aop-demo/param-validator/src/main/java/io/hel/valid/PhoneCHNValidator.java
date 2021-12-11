package io.hel.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * helei
 * 2021/11/18 14:43
 * description:
 */
@SuppressWarnings("all")
public class PhoneCHNValidator implements ConstraintValidator<PhoneCHN, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.length() != 11) {
            return false;
        }
        String regex = "^((13[0-9])|(14[5|7])|(15[0-9])|(166)|(17[0-8])|(18[0-9])|(19[8|9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(value);
        return m.matches();
    }
}
