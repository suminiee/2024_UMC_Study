package org.example.demo.study.converter;

import org.example.demo.study.domain.Member;
import org.example.demo.study.domain.Mission;
import org.example.demo.study.domain.enums.MissionStatus;
import org.example.demo.study.domain.mapping.MemberMission;
import org.example.demo.study.dto.mission.MemberMissionRequestDTO;
import org.example.demo.study.dto.mission.MemberMissionResponseDTO;
import org.example.demo.study.dto.mission.MissionResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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


    public static MemberMissionResponseDTO.memberMissionResultDTO toCompleteMissionResponseDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.memberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .status(memberMission.getStatus())
                .completedAt(memberMission.getUpdatedAt())
                .build();
    }


    public static MemberMissionResponseDTO.MemberMissionPreviewDTO memberMissionPreviewDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionPreviewDTO.builder()
                .ownerNickname(memberMission.getMember().getName())
                .storeNickname(memberMission.getMission().getStore().getName())
                .deadline(memberMission.getMission().getDeadline())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .build();

    }

    public static MemberMissionResponseDTO.MemberMissionPreviewListDTO memberMissionPreviewListDTO(Page<MemberMission> memberMissionList) {
        List<MemberMissionResponseDTO.MemberMissionPreviewDTO> memberMissionPreviewDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::memberMissionPreviewDTO).collect(Collectors.toList());

        return MemberMissionResponseDTO.MemberMissionPreviewListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalElement(memberMissionList.getTotalElements())
                .totalPage(memberMissionList.getTotalPages())
                .listSize(memberMissionPreviewDTOList.size())
                .memberMissionList(memberMissionPreviewDTOList)
                .build();
    }
}
