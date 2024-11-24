package org.example.demo.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.demo.study.validation.validator.RegionExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RegionExistValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistRegion {
    String message() default "존재하지 않는 지역입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
