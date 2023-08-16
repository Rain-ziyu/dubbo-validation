package com.platform.ahj.dubbocommon.validator;



import com.platform.ahj.dubbocommon.anno.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: ZiYu
 * @Created on: 2023/08/08 17:36
 * @Since:
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {
    // 构建正则表达式，用于实现之后的字符串校验
    private static final Pattern PATTERN = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 不为null才进行校验
        if (value != null && value.length() != 0) {
            // 使用正则表达式校验
            Matcher matcher = PATTERN.matcher(value);
            return matcher.find();
        }
        return false;
    }
}
