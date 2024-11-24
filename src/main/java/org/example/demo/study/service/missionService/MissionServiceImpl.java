package org.example.demo.study.service.missionService;

import lombok.RequiredArgsConstructor;
import org.example.demo.study.converter.MemberMissionConverter;
import org.example.demo.study.converter.MissionConverter;
import org.example.demo.study.domain.Member;
import org.example.demo.study.domain.Mission;
import org.example.demo.study.domain.Store;
import org.example.demo.study.domain.enums.MissionStatus;
import org.example.demo.study.domain.mapping.MemberMission;
import org.example.demo.study.dto.mission.MemberMissionRequestDTO;
import org.example.demo.study.dto.mission.MissionRequestDTO;
import org.example.demo.study.exception.mission.MissionErrorCode;
import org.example.demo.study.exception.mission.MissionException;
import org.example.demo.study.repository.MemberMissionRepository;
import org.example.demo.study.repository.MemberRepository;
import org.example.demo.study.repository.MissionRepository;
import org.example.demo.study.repository.storeRepo.StoreRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService{

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Override
    public Mission addMission(MissionRequestDTO.AddMission request) {

        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(
                () -> new MissionException(MissionErrorCode.STORE_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request, store);

        return missionRepository.save(newMission);
    }

    @Override
    public MemberMission addMemberMission(MemberMissionRequestDTO.AddMemberMission request) {


        //이미 존재하는 멤버 미션인지 확인
        memberMissionRepository.findByMissionIdAndMemberId(request.getMissionId(), request.getMemberId())
                .ifPresent(memberMission -> {
                    if (memberMission.getStatus() == MissionStatus.CHALLENGING) {
                        throw new MissionException(MissionErrorCode.MISSION_ALREADY_CHALLENGING);
                    }
                    if (memberMission.getStatus() == MissionStatus.COMPLETE) {
                        throw new MissionException(MissionErrorCode.MISSION_ALREADY_COMPLETED);
                    }
                });

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MissionException(MissionErrorCode.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionException(MissionErrorCode.MISSION_NOT_FOUND));

        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(request, member, mission);

        return memberMissionRepository.save(newMemberMission);
    }


}
