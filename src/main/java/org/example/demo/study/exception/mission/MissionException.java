package org.example.demo.study.exception.mission;

import org.example.demo.study.apiPayload.code.BaseErrorCode;
import org.example.demo.study.apiPayload.code.exception.GeneralException;

public class MissionException extends GeneralException {
    public MissionException(BaseErrorCode code) {
        super(code);
    }
}
