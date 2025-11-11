package tw.odk.spring6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.odk.spring6.entity.Employee;
import tw.odk.spring6.project.EmployeeProjection;
import tw.odk.spring6.repository.EmployeeRepository;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@GetMapping("/{id}")
	public ResponseEntity<Employee> test1(@PathVariable Integer id) {
		Employee e = employeeRepository.findById(id).orElse(null);
		return ResponseEntity.ok(e);
	}
	@GetMapping("/title/{key}")
	public ResponseEntity<List<EmployeeProjection>> test2(@PathVariable String key) {
		List<EmployeeProjection> sales = employeeRepository.searchByTitleStartingWith(key);
		return ResponseEntity.ok(sales);
	}
}
