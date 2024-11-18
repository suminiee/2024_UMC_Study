package org.example.demo.study.repository;

import org.example.demo.study.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    boolean existsById(Long regionId);
}
