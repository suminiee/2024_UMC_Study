package org.example.demo.study.service.storeService;

import org.example.demo.study.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    List<Object> findStoresByNameAndScore(String name, Float score);
}
