package org.example.demo.study.dto.review;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class AddReview {

        @NotNull(message = "리뷰 내용은 필수입니다.")
        String body;

        @NotNull(message = "평점 입력은 필수입니다.")
        Float score;

        @NotNull(message = "member id 입력은 필수입니다")
        Long memberId;

        @NotNull(message = "store_id 입력은 필수입니다.")
        Long storeId;

    }
}
