package org.example.demo.study.exception.mission;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.demo.study.apiPayload.code.BaseErrorCode;
import org.example.demo.study.apiPayload.code.ErrorReasonDTO;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum MissionErrorCode implements BaseErrorCode {
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE404", "가게를 찾을 수 없습니다."),
    ;


    private final HttpStatus status;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return null;
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return null;
    }
}
