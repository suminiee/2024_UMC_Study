package org.example.demo.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.demo.study.apiPayload.ApiResponse;
import org.example.demo.study.converter.StoreConverter;
import org.example.demo.study.domain.Store;
import org.example.demo.study.dto.store.StoreRequestDTO;
import org.example.demo.study.service.storeService.StoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/stores/add")
    ApiResponse<?> addStore(@RequestBody @Valid StoreRequestDTO.AddStore request) {
        Store storeResult = storeService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toAddResultDTO(storeResult));
    }
}
