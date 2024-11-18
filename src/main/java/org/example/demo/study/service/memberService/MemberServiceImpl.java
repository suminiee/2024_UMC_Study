package org.example.demo.study.service.memberService;

import lombok.RequiredArgsConstructor;
import org.example.demo.study.converter.MemberConverter;
import org.example.demo.study.converter.MemberPreferConverter;
import org.example.demo.study.domain.FoodCategory;
import org.example.demo.study.domain.Member;
import org.example.demo.study.domain.mapping.MemberPrefer;
import org.example.demo.study.dto.MemberRequestDTO;
import org.example.demo.study.exception.foodCategory.FoodCategoryErrorCode;
import org.example.demo.study.exception.foodCategory.FoodCategoryException;
import org.example.demo.study.repository.FoodCategoryRepository;
import org.example.demo.study.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryException(FoodCategoryErrorCode.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
