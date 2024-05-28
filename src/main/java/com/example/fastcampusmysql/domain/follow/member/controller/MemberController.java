package com.example.fastcampusmysql.domain.follow.member.controller;

import com.example.fastcampusmysql.domain.follow.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.follow.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.follow.member.service.MemberReadService;
import com.example.fastcampusmysql.domain.follow.member.service.MemberWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberWriteService memberWriteService;
    private final MemberReadService memberReadService;

    @PostMapping("/members")
    public MemberDto register(@RequestBody RegisterMemberCommand command) {
        var member = memberWriteService.register(command);
        return memberReadService.toDto(member);
    }

    @GetMapping("/members/{id}")
    public MemberDto getMember(@PathVariable Long id) {
        return memberReadService.getMember(id);
    }
}