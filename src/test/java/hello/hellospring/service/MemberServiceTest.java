package hello.hellospring.service;

import hello.hellospring.model.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;

    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clear();
    }

    @Test
    void joinTest() {
        // given
        Member member = new Member();
        member.setName("vividswan");

        // when
        Long memberId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(memberId).get();
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    public void duplicateNameTest(){

        // given
        Member member1 = new Member();
        member1.setName("vividswan");

        Member member2 = new Member();
        member2.setName("vividswan");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

/*        try{
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        // then

    }

    @Test
    void findMembersTest() {
        // given

        // when

        // then
    }

    @Test
    void findOneTest() {
        // given

        // when

        // then
    }
}