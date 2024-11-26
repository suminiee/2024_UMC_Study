package org.example.demo.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.demo.study.apiPayload.ApiResponse;
import org.example.demo.study.converter.StoreConverter;
import org.example.demo.study.domain.Store;
import org.example.demo.study.dto.review.ReviewResponseDTO;
import org.example.demo.study.dto.store.StoreRequestDTO;
import org.example.demo.study.service.storeService.StoreService;
import org.example.demo.study.validation.annotation.CheckPage;
import org.example.demo.study.validation.annotation.ExistStore;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
public class StoreRestController {

    private final StoreService storeService;

    @PostMapping("/stores/add")
    ApiResponse<?> addStore(@RequestBody @Valid StoreRequestDTO.AddStore request) {
        Store storeResult = storeService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toAddResultDTO(storeResult));
    }

    @GetMapping("/stores/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                            @CheckPage @RequestParam(name = "page") Integer page) {

        Integer zeroBasedPage = page - 1;
        return ApiResponse.onSuccess(StoreConverter.reviewPreviewListDTO(storeService.getReviewList(storeId, zeroBasedPage)));

    }
}
