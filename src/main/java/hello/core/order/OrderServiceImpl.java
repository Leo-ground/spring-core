package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //DIP 위반되기 때문에 인터페이스에만 의존하게 변경시도 1!. null point exception발생!!
    //private DiscountPolicy discountPolicy;

    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //생성자 주입을 한다 변경시도2 (member에서 해결한 방법을 먼저보기)
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
