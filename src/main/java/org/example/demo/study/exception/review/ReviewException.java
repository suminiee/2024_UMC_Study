package org.example.demo.study.exception.review;

import org.example.demo.study.apiPayload.code.BaseErrorCode;
import org.example.demo.study.apiPayload.code.exception.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode code) {
        super(code);
    }
}
