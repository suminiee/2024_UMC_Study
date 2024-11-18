package org.example.demo.study.service.reviewService;

import org.example.demo.study.domain.Review;
import org.example.demo.study.dto.review.ReviewRequestDTO;

public interface ReviewService {

    Review addReview(ReviewRequestDTO.AddReview reqest);
}
