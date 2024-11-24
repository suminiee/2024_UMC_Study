package org.example.demo.study.dto.mission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class AddMission {

        @NotNull(message = "리워드 값은 필수입니다.")
        Integer reward;

        @NotNull(message = "마감일 입력은 필수입니다.")
        LocalDate deadline;

        @NotNull(message = "미션 내용 입력은 필수입니다.")
        String missionSpec;

        @NotNull(message = "store_id 입력은 필수입니다.")
        Long storeId;
    }
}
