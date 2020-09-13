package hello.hellospring.repository;

import hello.hellospring.model.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clear();
    }

    @Test
    public void equalTest(){
        Member member = new Member();
        member.setName("vividswan");

        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByNameTest(){
        Member member = new Member();
        member.setName("vividswan");

        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findByName("vividswan").get();

        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findAllTest(){
        Member member1 = new Member();
        member1.setName("member1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        memoryMemberRepository.save(member2);

        List<Member> list = memoryMemberRepository.findAll();

        assertThat(list.size()).isEqualTo(2);
    }

}
