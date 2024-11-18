package org.example.demo.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.example.demo.study.exception.store.StoreErrorCode;
import org.example.demo.study.repository.RegionRepository;
import org.example.demo.study.validation.annotation.ExistRegion;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegionExistValidator implements ConstraintValidator<ExistRegion, Long> {

    private RegionRepository regionRepository;


    @Override
    public void initialize(ExistRegion constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long regioinId, ConstraintValidatorContext context) {
//        return value != null && regionRepository.existsById(value);
        if (regioinId == null) {
            return true;
        }
        boolean exists = regionRepository.existsById(regioinId);

        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(StoreErrorCode.REGION_CATEGORY_NOT_FOUND.toString())
                    .addConstraintViolation();
        }
        return exists;
    }
}
