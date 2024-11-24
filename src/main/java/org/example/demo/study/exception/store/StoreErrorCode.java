package org.example.demo.study.exception.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.demo.study.apiPayload.code.BaseErrorCode;
import org.example.demo.study.apiPayload.code.ErrorReasonDTO;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StoreErrorCode implements BaseErrorCode {

    REGION_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION400", "지역을 찾을 수 없습니다."),
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
