package tw.odk.spring6.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class OrderDetailDto {
	private BigDecimal unitPrice;
	private Integer quantity;
	private String productName;
	
}
