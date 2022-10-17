package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // OrderService 인터페이스의 구현체
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discointPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discointPrice);
    }

    // 테스트 요도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
