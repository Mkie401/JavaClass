package tw.odk.spring6.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orderdetails")
@IdClass(OrderDetailsPK.class)
@Data
public class OrderDetail {
	
	@Id
	@Column(name = "OrderID")
	private Integer orderId;
	@Id
	@Column(name = "ProductID")
	private Integer productId;
	
	@Column(name = "UnitPrice")
	private BigDecimal unitprice;
	
	@Column(name = "Quantity")
	private Integer quantity;
	//------------------------------
	@ManyToOne
	@JoinColumn(name = "OrderID")
	@JsonBackReference
	private Order order;
}
