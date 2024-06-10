package com.example.fastcampusmysql.domain.util;

import com.example.fastcampusmysql.domain.member.entity.Member;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class MemberFixtureFactory {

    public static Member createMember() {
        var param = new EasyRandomParameters();
        return new EasyRandom(param).nextObject(Member.class);
    }

    public static Member createMember(Long seed) {
        var param = new EasyRandomParameters().seed(seed);
        return new EasyRandom(param).nextObject(Member.class);
    }
}
