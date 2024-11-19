package org.example.demo.study.service.missionService;

import org.example.demo.study.domain.Mission;
import org.example.demo.study.domain.mapping.MemberMission;
import org.example.demo.study.dto.mission.MemberMissionRequestDTO;
import org.example.demo.study.dto.mission.MissionRequestDTO;

public interface MissionService {
    Mission addMission(MissionRequestDTO.AddMission request);

    MemberMission addMemberMission(MemberMissionRequestDTO.AddMemberMission request);

}
