package org.example.demo.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.demo.study.apiPayload.ApiResponse;
import org.example.demo.study.converter.ReviewConverter;
import org.example.demo.study.converter.StoreConverter;
import org.example.demo.study.domain.Review;
import org.example.demo.study.dto.review.ReviewRequestDTO;
import org.example.demo.study.dto.review.ReviewResponseDTO;
import org.example.demo.study.service.reviewService.ReviewService;
import org.example.demo.study.validation.annotation.CheckPage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewService reviewService;

    @PostMapping("/reviews/add")
    ApiResponse<?> addStoreReview(@RequestBody @Valid ReviewRequestDTO.AddReview request) {
        Review reviewResult = reviewService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddResultDTO(reviewResult));
    }

    @GetMapping("/member/{memberId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "특정 유저의 리뷰(나) 목록을 조회하는 API, 페이징을 포함합니다. query String으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "memberId", description = "멤버 아이디, path variable 입니다.")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getMyReviews(@PathVariable(name = "memberId") Long memberId,
                                                       @CheckPage @RequestParam(name = "page") Integer page) {

        Integer zeroBasedPage = page - 1;
        return ApiResponse.onSuccess(StoreConverter.reviewPreviewListDTO(reviewService.getMyReviewList(memberId, zeroBasedPage)));
    }


}
