package tw.odk.spring6.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderDto {
	private Integer orderId;
	private Date orderDate;
	private List<OrderDetailDto> details;
}
