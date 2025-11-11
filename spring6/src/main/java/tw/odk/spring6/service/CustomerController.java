package tw.odk.spring6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.odk.spring6.entity.Customer;
import tw.odk.spring6.repository.CustomerRepository;

@RequestMapping("/customer")
@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	@GetMapping("/v1/{id}")
	public ResponseEntity<Customer> test1(@PathVariable String id) {
		
		Customer c = customerRepository.findById(id).orElse(null);
		
		return ResponseEntity.ok(c);
	}
	
	@GetMapping("/v2/{id}")
	public ResponseEntity<Customer> test2(@PathVariable String id) {
		
		Customer c = customerRepository.findByCustomerID(id).orElse(null);
		
		return ResponseEntity.ok(c);
	}
	
	@GetMapping("/v3/{id}")
	public ResponseEntity<Customer> test3(@PathVariable String id) {
		
		Customer c = customerRepository.findById(id).orElse(null);
		
		return ResponseEntity.ok(c);
	}
}
