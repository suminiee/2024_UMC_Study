package org.example.demo.study.service.memberService;

import org.example.demo.study.domain.Member;
import org.example.demo.study.dto.MemberRequestDTO;

import java.util.Optional;

public interface MemberService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    Optional<Member> findMember(Long id);
}
