package org.example.demo.study.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.example.demo.study.converter.ReviewConverter;
import org.example.demo.study.domain.Member;
import org.example.demo.study.domain.Review;
import org.example.demo.study.domain.Store;
import org.example.demo.study.dto.review.ReviewRequestDTO;
import org.example.demo.study.exception.review.ReviewErrorCode;
import org.example.demo.study.exception.review.ReviewException;
import org.example.demo.study.repository.MemberRepository;
import org.example.demo.study.repository.ReviewRepository;
import org.example.demo.study.repository.storeRepo.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Review addReview(ReviewRequestDTO.AddReview reqest) {

        Store store = storeRepository.findById(reqest.getStoreId()).orElseThrow(
                () -> new ReviewException(ReviewErrorCode.STORE_NOT_FOUND));

        Member member = memberRepository.findById(reqest.getMemberId()).orElseThrow(
                () -> new ReviewException(ReviewErrorCode.MEMBER_NOT_FOUND));

        Review newReview = ReviewConverter.toReview(reqest, member, store);

        return reviewRepository.save(newReview);
    }
}
