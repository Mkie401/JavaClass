package tw.odk.spring6.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class OrderDetailDto {
	private BigDecimal unitPrice;
	private Integer quantity;
	private String productName;
	
}
