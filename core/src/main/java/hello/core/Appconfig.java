package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceimpl;

public class Appconfig {

//    public MemberService memberService(){
//        return new MemberServiceimpl(new MemoryMemberRepository());
//    };
//
//    public OrderService orderService(){
//        return new OrderServiceimpl( new MemoryMemberRepository(), new FixDiscountPolicy());
//    }


    //저장소의 역할
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();       //메모리 회원 저장소를 사용
    };

    // 할인 정책의 역할
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();     // 고정 할인 정책을 사용
    }

    // MemberService의 역할 (생성자 주입)
    public MemberService memberService(){
        return new MemberServiceimpl(memberRepository());
    }

    // orderService 의 역할
    public OrderService orderService(){
        return new OrderServiceimpl(memberRepository(), discountPolicy());
    }
}
