package org.example.demo.study.repository;

import org.example.demo.study.domain.enums.MissionStatus;
import org.example.demo.study.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Optional<MemberMission> findByMissionIdAndMemberId(Long missionId, Long memberId);
}
