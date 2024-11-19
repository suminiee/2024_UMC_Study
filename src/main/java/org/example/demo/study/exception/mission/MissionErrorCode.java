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
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER404", "유저 정보를 찾을 수 없습니다."),
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION404", "미션 정보를 찾을 수 없습니다."),
    MEMBER_MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_MISSION404", "멤버 미션 정보를 찾을 수 없습니다."),
    MISSION_ALREADY_CHALLENGING(HttpStatus.INTERNAL_SERVER_ERROR, "MEMBER_MISSION404", "이미 도전중인 미션입니다."),
    MISSION_ALREADY_COMPLETED(HttpStatus.INTERNAL_SERVER_ERROR, "MEMBER_MISSION404", "이미 완료된 미션입니다."),
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
