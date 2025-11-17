package tw.odk.spring7.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tw.odk.spring7.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>,
	JpaSpecificationExecutor<Employee>{
	//JPQL
	@Query("""
			SELECT e
			FROM Employee e
			WHERE e.Salary > :low
			""")
	List<Employee> test1(@Param("low") Float low);
	//Native SQL
		@Query( value = """
				SELECT * FROM employees WHERE Salary < :high
			""", nativeQuery = true	)
		List<Employee> test2(@Param("high") Float high);
		
}
