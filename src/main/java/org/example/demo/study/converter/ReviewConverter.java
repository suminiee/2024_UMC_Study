package org.example.demo.study.converter;

import org.example.demo.study.domain.Member;
import org.example.demo.study.domain.Review;
import org.example.demo.study.domain.Store;
import org.example.demo.study.dto.review.ReviewRequestDTO;
import org.example.demo.study.dto.review.ReviewResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static ReviewResponseDTO.MyReviewPreviewDTO myReviewPreviewDTO(Review review) {
        return ReviewResponseDTO.MyReviewPreviewDTO.builder()
                .name(review.getMember().getName())
                .score(review.getScore())
                .body(review.getBody())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewResponseDTO.MyReviewPreviewListDTO myReviewPreviewListDTO(Page<Review> reviewsList) {
        List<ReviewResponseDTO.MyReviewPreviewDTO> myReviewPreviewDTOList = reviewsList.stream()
                .map(ReviewConverter::myReviewPreviewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.MyReviewPreviewListDTO.builder()
                .myReviewList(myReviewPreviewDTOList)
                .listSize(myReviewPreviewDTOList.size())
                .totalPage(reviewsList.getTotalPages())
                .totalElement(reviewsList.getTotalElements())
                .isFirst(reviewsList.isFirst())
                .isLast(reviewsList.isLast())
                .build();
    }
}
