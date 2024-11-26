package org.example.demo.study.service.storeService;

import lombok.RequiredArgsConstructor;
import org.example.demo.study.converter.StoreConverter;
import org.example.demo.study.domain.Region;
import org.example.demo.study.domain.Review;
import org.example.demo.study.domain.Store;
import org.example.demo.study.dto.store.StoreRequestDTO;
import org.example.demo.study.exception.store.StoreErrorCode;
import org.example.demo.study.exception.store.StoreException;
import org.example.demo.study.repository.RegionRepository;
import org.example.demo.study.repository.ReviewRepository;
import org.example.demo.study.repository.storeRepo.StoreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    @Override
    public Store addStore(StoreRequestDTO.AddStore request) {
        Region region = regionRepository.findById(request.getRegionId()).orElseThrow(() ->
                new StoreException(StoreErrorCode.REGION_CATEGORY_NOT_FOUND));

        Store newStore = StoreConverter.toStore(request, region);

        return storeRepository.save(newStore);

    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        Page<Review> storePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return storePage;
    }

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

}
