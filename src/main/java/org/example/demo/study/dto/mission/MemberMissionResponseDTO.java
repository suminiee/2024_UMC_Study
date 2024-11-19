package org.example.demo.study.dto.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.demo.study.domain.enums.MissionStatus;

import java.time.LocalDateTime;

public class MemberMissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addMemberMissionResultDTO {
        Long memberMissionId;
        MissionStatus status;
        LocalDateTime createdAt;
    }
}
