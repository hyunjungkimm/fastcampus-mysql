package com.example.fastcampusmysql.domain.follow.member.service;

import com.example.fastcampusmysql.domain.follow.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.follow.member.entity.Member;
import com.example.fastcampusmysql.domain.follow.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberWriteService {

    private final MemberRepository memberRepository;

    public Member register(RegisterMemberCommand command) {

        /*
        목표 - 회원정보(이메일, 닉네임, 생년월일)을 등록한다.
            - 닉네임은 10자를 넘길 수 없다.
        파라미터 - memberRegisterCommand

        Member member = Member.of(memberRegisterCommand)
        memberRepository.save()
         */

        Member member = Member.builder()
                .nickname(command.nickname())
                .email(command.email())
                .birthday(command.birthday())
                .build();

        return memberRepository.save(member);
    }
}
