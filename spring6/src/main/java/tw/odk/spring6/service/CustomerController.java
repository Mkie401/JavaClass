package tw.odk.spring6.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.odk.spring6.dto.CustomerDto;
import tw.odk.spring6.dto.OrderDetailDto;
import tw.odk.spring6.dto.OrderDto;
import tw.odk.spring6.entity.Customer;
import tw.odk.spring6.entity.Order;
import tw.odk.spring6.entity.OrderDetail;
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
	public ResponseEntity<CustomerDto> test3(@PathVariable String id) {
		Customer c = customerRepository.findById(id).orElse(null);
		ArrayList<OrderDto> oDto = new ArrayList<>();
		List<Order> orders = c.getOrders();
		for (Order order : orders) {
			ArrayList<OrderDetailDto> odDto = new ArrayList<>();
			for (OrderDetail detail : order.getOrderDetails()) {
				OrderDetailDto dto = new OrderDetailDto(
						detail.getUnitprice(),
						detail.getQuantity(),
						detail.getProduct().getProductname());
				odDto.add(dto);
			}
			OrderDto dto = new OrderDto(
					order.getOrderid(),
					order.getOrderdate(),
					odDto);
			oDto.add(dto);
		}
		CustomerDto cDto = new CustomerDto(c.getCustomerid(), c.getCompanyName(), oDto);
		return ResponseEntity.ok(cDto);
	}
}
