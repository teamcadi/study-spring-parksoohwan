package hello.hellospring.service;

import hello.hellospring.model.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository){
        this.repository = repository;
    }

    public Long join(Member member){
        validateDuplicateMember(member);
        repository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        repository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return repository.findAll();
    }

    public Optional<Member> findOne(Long id){
        return repository.findById(id);
    }
}
