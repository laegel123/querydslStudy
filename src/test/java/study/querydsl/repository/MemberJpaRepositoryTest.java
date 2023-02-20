package study.querydsl.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.Member;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    public void basicTest() throws Exception {
        // given
        Member member = new Member("member1", 10);
        memberJpaRepository.save(member);

        Member findMember = memberJpaRepository.findById(member.getId()).get();
        List<Member> members = memberJpaRepository.findAll();
        List<Member> member1 = memberJpaRepository.findByUsername("member1");

        // when
        assertEquals(member, findMember);
        assertEquals(members.get(0), member);
        assertEquals(member1.get(0), member);

        // then

    }

    @Test
    public void basicQuerydslTest() throws Exception {
        // given
        Member member = new Member("member1", 10);
        memberJpaRepository.save(member);

        Member findMember = memberJpaRepository.findById(member.getId()).get();
        List<Member> members = memberJpaRepository.findAll_Querydsl();
        List<Member> member1 = memberJpaRepository.findByUsername_Querydsl("member1");

        // when
        assertEquals(member, findMember);
        assertEquals(members.get(0), member);
        assertEquals(member1.get(0), member);

        // then

    }

}
