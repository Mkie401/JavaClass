package tw.odk.spring6.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class CustomerDto {
	private String customerId;
	private String companyName;
	private List<OrderDto> orders;
}
