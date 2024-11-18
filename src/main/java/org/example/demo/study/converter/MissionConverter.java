package org.example.demo.study.converter;

import org.example.demo.study.domain.Mission;
import org.example.demo.study.domain.Store;
import org.example.demo.study.dto.mission.MissionRequestDTO;
import org.example.demo.study.dto.mission.MissionResponseDTO;

public class MissionConverter {

    public static MissionResponseDTO.addMissionResultDTO toAddResultDTO(Mission mission) {
        return MissionResponseDTO.addMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.AddMission request, Store store) {
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .build();
    }
}
