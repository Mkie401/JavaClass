package tw.odk.spring7.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import tw.odk.spring7.entity.Employee;
import tw.odk.spring7.repo.EmployeeRepo;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepo repo;
	
	@RequestMapping("/test1")
	public void test1() {
		repo.test1(2000f).forEach(employee -> {
			System.out.printf("%s %s:%f\n",
					employee.getFirstName(),
					employee.getLastName(),
					employee.getSalary());
		});
	}
	
	@RequestMapping("/test2")
	public void test2() {
		repo.test2(2000f).forEach(employee -> {
			System.out.printf("%s %s:%f\n",
					employee.getFirstName(),
					employee.getLastName(),
					employee.getSalary());
		});
	}
	
	@Autowired
	private EntityManager em;
	
	@RequestMapping("/test3")
	public void test3() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		//---------------------------------------------------------------
		Root<Employee> root = cq.from(Employee.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		predicates.add(cb.like(root.get("FirstName"), "A%"));
		predicates.add(cb.greaterThan(root.get("Salary"), 2000f));
		
		cq.select(root).where(cb.and(predicates.toArray(new Predicate[0])));
		
		em.createQuery(cq).getResultList().forEach(e -> {
			System.out.printf("%s %s:%f\n",
					e.getFirstName(),
					e.getLastName(),
					e.getSalary());
		});
		
	}
}
