package tw.odk.spring10.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.odk.spring10.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	Optional<Member> findByAccount(String account);
}
