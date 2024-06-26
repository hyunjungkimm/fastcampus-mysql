package com.example.fastcampusmysql.application.usacase;

import com.example.fastcampusmysql.domain.follow.service.FollowWriteService;
import com.example.fastcampusmysql.domain.member.service.MemberReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateFollowMemberUsacase { // 클래스명 동사 - 기능 하나만 하는 유스케이스를 만들기 위해 명시적으로 씀

    private final MemberReadService memberReadService;
    private final FollowWriteService followWriteService;

    public void execute(Long fromMemberId, Long toMemberId) {
        /*
        * 1. 입력받은 memberId로 회원 조회
        * 2. FollowWriteService.create()
        * */
        var fromMember = memberReadService.getMember(fromMemberId);
        var toMember = memberReadService.getMember(toMemberId);

        followWriteService.create(fromMember,toMember);
    }

}
