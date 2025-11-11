package tw.odk.spring6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.odk.spring6.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	/*
	 * 動詞 + By + 屬性名稱 -> 
	 * findByEmail(String email) -> Optional<Member>
	 * findAllByAge(Integer age) -> List<Member>
	 * coountByName(String name) -> Long
	 * deleteByName(String name)
	 * 
	 *  And/Or
	 *  findByNameAndAge(String name, Integer age)
	 *  findByNameOrge(String name, Integer age)
	 *  
	 *  Between/LessThan/GreateThan/LessThanEqual/GreatThanEqual
	 *  findByOrderDateBetween(Date/LOcalDate,Date/LocalDate)
	 *  
	 *  Like/NotLike/StartingWith/EndingWith/Containing
	 *  findByNameLike(String)
	 *  
	 *  IsNull/IsNotNull
	 *  OrderBy + 屬性 + Asc/Desc
	 *  findByLastNameLikeOrderByFirstNameAscAndLastNameDesc(String)
	 * 
	 */
	
	
}
