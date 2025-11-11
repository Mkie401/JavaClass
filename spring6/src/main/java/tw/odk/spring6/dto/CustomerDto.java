package tw.odk.spring6.dto;

import java.util.List;

import lombok.Data;
@Data
public class CustomerDto {
	private String customerId;
	private String companyName;
	private List<OrderDto> orders;
}
