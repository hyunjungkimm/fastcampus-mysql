package com.example.fastcampusmysql.domain.follow.member.service;

import com.example.fastcampusmysql.domain.follow.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.follow.member.entity.Member;
import com.example.fastcampusmysql.domain.follow.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberReadService {

    private final MemberRepository memberRepository;

    public MemberDto getMember(Long id) {
        var member = memberRepository.findById(id).orElseThrow();
        return toDto(member);
    }

    public MemberDto toDto(Member member) {
        return new MemberDto(member.getId(), member.getEmail(), member.getNickname(), member.getBirthday());
    }
}
