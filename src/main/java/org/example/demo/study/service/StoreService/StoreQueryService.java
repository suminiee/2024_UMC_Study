package org.example.demo.study.service.StoreService;

import org.example.demo.study.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
}
