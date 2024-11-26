package org.example.demo.study.repository;

import org.example.demo.study.domain.Member;
import org.example.demo.study.domain.Mission;
import org.example.demo.study.domain.enums.MissionStatus;
import org.example.demo.study.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Optional<MemberMission> findByMissionIdAndMemberId(Long missionId, Long memberId);
    Page<MemberMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest);

    MemberMission findByMemberAndMission(Member member, Mission mission);
}
