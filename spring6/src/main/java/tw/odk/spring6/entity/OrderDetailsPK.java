package tw.odk.spring6.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailsPK implements Serializable{
	
	
	private Integer orderId;
	private Integer productId;
	
	@Override
	public int hashCode() {
		return Objects.hash(orderId,productId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof OrderDetailsPK)) return false;
		OrderDetailsPK other = (OrderDetailsPK)obj;
		return other.orderId == this.orderId && other.productId == this.productId;
	}
}
