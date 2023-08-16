package com.platform.ahj.dubbocommon.anno;




import com.platform.ahj.dubbocommon.validator.PhoneValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Description:
 * @Author: ZiYu
 * @Created on: 2023/08/08 17:35
 * @Since:
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
// @Constraint(validatedBy = { })
// 自定义注解关联校验器  也可以不使用该注解 通过Hibernate Validator提供的Validator发现机制去完成关联
@Constraint(validatedBy = {PhoneValidator.class})
public @interface Phone {

    // 默认错误消息
    String message() default "手机号错误";

    // 分组
    Class<?>[] groups() default {};

    // 负载
    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Phone[] value();
    }
}