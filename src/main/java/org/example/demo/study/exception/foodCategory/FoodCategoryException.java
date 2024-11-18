package org.example.demo.study.exception.foodCategory;

import org.example.demo.study.apiPayload.code.BaseErrorCode;
import org.example.demo.study.apiPayload.code.exception.GeneralException;

public class FoodCategoryException extends GeneralException {
    public FoodCategoryException(BaseErrorCode code) {
        super(code);
    }
}
