package org.example.demo.study.service.storeService;

import org.example.demo.study.domain.Store;
import org.example.demo.study.dto.store.StoreRequestDTO;

public interface StoreService {
    Store addStore(StoreRequestDTO.AddStore request);
}
