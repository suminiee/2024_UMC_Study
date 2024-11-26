package org.example.demo.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.demo.study.validation.validator.PageCheckValidator;
import org.example.demo.study.validation.validator.StoreExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageCheckValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "사용할 수 없는 페이지 수 입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
