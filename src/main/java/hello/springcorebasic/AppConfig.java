package hello.springcorebasic;

import hello.springcorebasic.discount.DiscountPolicy;
import hello.springcorebasic.discount.FixDiscountPolicy;
import hello.springcorebasic.discount.RateDiscountPolicy;
import hello.springcorebasic.member.MemberRepository;
import hello.springcorebasic.member.MemberService;
import hello.springcorebasic.member.MemberServiceImpl;
import hello.springcorebasic.member.MemoryMemberRepository;
import hello.springcorebasic.order.OrderService;
import hello.springcorebasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
            memberRepository(),
            discountPolicy()
        );
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
