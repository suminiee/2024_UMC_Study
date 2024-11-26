package org.example.demo.study.service.reviewService;

import org.example.demo.study.domain.Review;
import org.example.demo.study.dto.review.ReviewRequestDTO;
import org.springframework.data.domain.Page;

public interface ReviewService {

    Review addReview(ReviewRequestDTO.AddReview request);

    Page<Review> getMyReviewList(Long memberId, Integer page);

}
