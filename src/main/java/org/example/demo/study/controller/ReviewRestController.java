package org.example.demo.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.demo.study.apiPayload.ApiResponse;
import org.example.demo.study.converter.ReviewConverter;
import org.example.demo.study.domain.Review;
import org.example.demo.study.dto.review.ReviewRequestDTO;
import org.example.demo.study.service.reviewService.ReviewService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewService reviewService;

    @PostMapping("/reviews/add")
    ApiResponse<?> addStoreReview(@RequestBody @Valid ReviewRequestDTO.AddReview request) {
        Review reviewResult = reviewService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddResultDTO(reviewResult));
    }
}
