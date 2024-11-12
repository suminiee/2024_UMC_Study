package org.example.demo.study.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.demo.study.apiPayload.code.BaseCode;
import org.example.demo.study.apiPayload.code.ReasonDTO;
import org.springframework.http.HttpStatus;

import java.security.cert.CertPathValidatorException;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    // 일반적인 응답
    _OK(HttpStatus.OK, "COMMON200", "성공입니다.");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
