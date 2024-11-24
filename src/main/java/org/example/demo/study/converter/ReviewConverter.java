package org.example.demo.study.converter;

import org.example.demo.study.domain.Member;
import org.example.demo.study.domain.Review;
import org.example.demo.study.domain.Store;
import org.example.demo.study.dto.review.ReviewRequestDTO;
import org.example.demo.study.dto.review.ReviewResponseDTO;

public class ReviewConverter {

    public static ReviewResponseDTO.addReviewResultDTO toAddResultDTO(Review review) {
        return ReviewResponseDTO.addReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.AddReview request, Member member, Store store) {
        return Review.builder()
                .score(request.getScore())
                .body(request.getBody())
                .store(store)
                .member(member)
                .build();
    }
}
