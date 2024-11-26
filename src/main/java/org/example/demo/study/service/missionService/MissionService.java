package org.example.demo.study.service.missionService;

import org.example.demo.study.domain.Mission;
import org.example.demo.study.domain.mapping.MemberMission;
import org.example.demo.study.dto.mission.MemberMissionRequestDTO;
import org.example.demo.study.dto.mission.MemberMissionResponseDTO;
import org.example.demo.study.dto.mission.MissionRequestDTO;
import org.springframework.data.domain.Page;

public interface MissionService {
    Mission addMission(MissionRequestDTO.AddMission request);

    MemberMission addMemberMission(MemberMissionRequestDTO.AddMemberMission request);

    Page<Mission> getMissionList(Long storeId, Integer page);

    Page<MemberMission> getChallengingMemberMissionList(Long memberId, Integer page);

    MemberMission completeMission(Long memberId, Long missionId);

}
