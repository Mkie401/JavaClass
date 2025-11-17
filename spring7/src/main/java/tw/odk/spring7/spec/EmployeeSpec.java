package tw.odk.spring7.spec;



import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import tw.odk.spring7.entity.Employee;

public class EmployeeSpec {
	
	public static Specification<Employee> firstNameEquals(String FirstName) {
		Specification<Employee> spec = new Specification<Employy>() {
			public Predicate topPredicate(
					Root<Employee> root,
					CriteriaQuery<?> query,
					CriteriaBuilder cb
					) {
				if(FirstName == null) return null;
				return cb.equal(root.get("FirstName"), FirstName);
			}
		}
		return null;
	}
	
	public static Specification<Employee> firstNameEquals(String FirstName) {
		return null;
	}
	
	public static Specification<Employee> LastNameEquals(String LastName) {
		return null;
	}
	
	public static Specification<Employee> TitleNameEquals(String Title) {
		return null;
	}
	
}
