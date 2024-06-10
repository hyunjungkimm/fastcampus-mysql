package com.example.fastcampusmysql.domain.member;

import com.example.fastcampusmysql.domain.util.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberTest {

    @DisplayName("회원은 닉네임을 변경할 수 있다")
    @Test
    void changeNickname(){
        var member = MemberFixtureFactory.createMember();
        var newNickname = "peu";

        member.changeNickname(newNickname);

        Assertions.assertEquals(newNickname, member.getNickname());
    }

    @DisplayName("회원 닉네임은 10글자를 초과할 수 없다")
    @Test
    void testNicknameMaxLength() {
        var member = MemberFixtureFactory.createMember();
        var overMaxLengthName = "peupeupeupeupeupeupeupeupeupeupe";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> member.changeNickname(overMaxLengthName)
        );
    }
}
