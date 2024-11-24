package org.example.demo.study.converter;

import org.example.demo.study.domain.Member;
import org.example.demo.study.domain.Mission;
import org.example.demo.study.domain.enums.MissionStatus;
import org.example.demo.study.domain.mapping.MemberMission;
import org.example.demo.study.dto.mission.MemberMissionRequestDTO;
import org.example.demo.study.dto.mission.MemberMissionResponseDTO;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.addMemberMissionResultDTO addMemberMissionResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.addMemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .status(memberMission.getStatus())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.AddMemberMission request, Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
