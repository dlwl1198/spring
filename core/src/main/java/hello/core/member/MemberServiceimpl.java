package hello.core.member;

public class MemberServiceimpl implements MemberService{

    private final MemberRepository memberRepository ;

    // 의존성 주입
    public MemberServiceimpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
//        memberRepository.findById(memberId);
//        return null;
        return memberRepository.findById(memberId);
    }
}
