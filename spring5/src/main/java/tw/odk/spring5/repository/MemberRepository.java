package tw.odk.spring5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.odk.spring5.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	Member findByAccount(String account);
}
