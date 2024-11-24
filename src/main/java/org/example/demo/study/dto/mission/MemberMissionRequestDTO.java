package org.example.demo.study.dto.mission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MemberMissionRequestDTO {

    @Getter
    public static class AddMemberMission {

        @NotNull(message = "member_id 값 입력은 필수입니다.")
        Long memberId;

        @NotNull(message = "mission_id 값 입력은 필수입니다.")
        Long missionId;
    }
}
