package org.example.demo.study.service.memberService;

import org.example.demo.study.domain.Member;
import org.example.demo.study.dto.MemberRequestDTO;

public interface MemberService {

    Member joinMember(MemberRequestDTO.JoinDto request);
}
