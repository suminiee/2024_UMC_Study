package org.example.demo.study.service.storeService;

import lombok.RequiredArgsConstructor;
import org.example.demo.study.converter.StoreConverter;
import org.example.demo.study.domain.Region;
import org.example.demo.study.domain.Store;
import org.example.demo.study.dto.store.StoreRequestDTO;
import org.example.demo.study.exception.store.StoreErrorCode;
import org.example.demo.study.exception.store.StoreException;
import org.example.demo.study.repository.RegionRepository;
import org.example.demo.study.repository.storeRepo.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Transactional
    @Override
    public Store addStore(StoreRequestDTO.AddStore request) {
        Region region = regionRepository.findById(request.getRegionId()).orElseThrow(() ->
                new StoreException(StoreErrorCode.REGION_CATEGORY_NOT_FOUND));

        Store newStore = StoreConverter.toStore(request, region);

        return storeRepository.save(newStore);

    }
}
