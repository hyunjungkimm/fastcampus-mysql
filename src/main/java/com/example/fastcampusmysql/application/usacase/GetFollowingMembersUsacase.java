package com.example.fastcampusmysql.application.usacase;

import com.example.fastcampusmysql.domain.follow.dto.FollowDto;
import com.example.fastcampusmysql.domain.follow.entity.Follow;
import com.example.fastcampusmysql.domain.follow.service.FollowReadService;
import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.service.MemberReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetFollowingMembersUsacase {

    private final MemberReadService memberReadService;
    private final FollowReadService followReadService;

    public List<MemberDto> execute(Long memberId) {
//        /*
//        * 1. fromMemberId = memberID -> Follow list
//        * 2. 1번을 순회하면서 회원정보를 찾으면 됨
//        * */
        var followings = followReadService.getFollowings(memberId);
        var followingMemberIds = followings.stream().map(FollowDto::toMemberId).toList();
        return memberReadService.getMembers(followingMemberIds);
    }
}