package org.example.demo.study.converter;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.demo.study.domain.Region;
import org.example.demo.study.domain.Store;
import org.example.demo.study.dto.store.StoreRequestDTO;
import org.example.demo.study.dto.store.StoreResponseDTO;
import org.example.demo.study.repository.RegionRepository;

public class StoreConverter {

    private static RegionRepository regionRepository;


    public static StoreResponseDTO.AddResultDTO toAddResultDTO(Store store) {
        return StoreResponseDTO.AddResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequestDTO.AddStore request, Region region) {

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .score(0.0f)
                .build();
    }
}
