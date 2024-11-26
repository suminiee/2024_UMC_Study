package org.example.demo.study.service.storeService;

import org.example.demo.study.domain.Review;
import org.example.demo.study.domain.Store;
import org.example.demo.study.dto.store.StoreRequestDTO;
import org.springframework.data.domain.Page;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface StoreService {
    Store addStore(StoreRequestDTO.AddStore request);

    Page<Review> getReviewList(Long storeId, Integer page);

    Optional<Store> findStore(Long id);
}
