package tw.odk.spring6.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "orders")
@Data
public class Order {

	
	@Id
	@Column(name = "OrderID")
	private  Integer orderid;
	@Column(name = "OrderDate")
	private Date orderdate;
	//----------------------------
	@ManyToOne
	@JoinColumn(name = "CustomerID")
	@JsonBackReference
	private Customer customer;
}
