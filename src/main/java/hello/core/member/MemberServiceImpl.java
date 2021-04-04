package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //역할 뿐만 아니라 구현에도 의존하는 현상이다.
    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    //DIP 위반 문제점을 해결하기위해 AppConfig사용 (기획자)/ 생성자를 생성
    private final MemberRepository memberRepository;

    //생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
