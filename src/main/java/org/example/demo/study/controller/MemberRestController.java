package org.example.demo.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.demo.study.apiPayload.ApiResponse;
import org.example.demo.study.converter.MemberConverter;
import org.example.demo.study.domain.Member;
import org.example.demo.study.dto.MemberRequestDTO;
import org.example.demo.study.dto.MemberResponseDTO;
import org.example.demo.study.service.memberService.MemberService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member =  memberService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }


}
