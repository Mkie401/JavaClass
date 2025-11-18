package tw.odk.spring11.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.odk.spring11.entity.Member;

public interface MemberRepo extends JpaRepository<Member, Integer>{
	Optional<Member> findByAccount(String account);
}
