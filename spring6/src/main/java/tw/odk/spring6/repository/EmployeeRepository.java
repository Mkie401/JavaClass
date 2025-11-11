package tw.odk.spring6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.odk.spring6.entity.Employee;
import tw.odk.spring6.project.EmployeeProjection;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<EmployeeProjection> searchByTitleStartingWith(String start);
}
