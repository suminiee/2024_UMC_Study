package org.example.demo.study.repository;

import org.example.demo.study.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
