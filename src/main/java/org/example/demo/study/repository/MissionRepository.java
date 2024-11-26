package org.example.demo.study.repository;

import org.example.demo.study.domain.Mission;
import org.example.demo.study.domain.Review;
import org.example.demo.study.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);

}
