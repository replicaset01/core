package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        // VIP회원 생성
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        // DB에 멤버 저장
        memberService.join(member);
        // 구현체(주문) 생성
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        // order클래스에 정의 해놓은 toString이 출력됨
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
