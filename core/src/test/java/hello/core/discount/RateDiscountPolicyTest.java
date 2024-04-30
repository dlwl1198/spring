package hello.core.discount;


import hello.core.Appconfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberServiceimpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {

    MemberService memberService;
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @BeforeEach
    void setUp() {
        Appconfig appConfig = new Appconfig();
        memberService = appConfig.memberService();
    }

    @Test
    void discount(){
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member memberB = new Member(2L, "memberB", Grade.VIP);
        memberService.join(memberB);

        int discountA = discountPolicy.discount(memberA, 20000);
        int discountB = discountPolicy.discount(memberB, 10000);

        Assertions.assertThat(discountA).isEqualTo(2000);
        Assertions.assertThat(discountB).isEqualTo(1000);


    }

}
