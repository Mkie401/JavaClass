package tw.odk.spring6.project;
/*
 * 方法名稱 => Entity
 * 
 */

import java.util.List;

import tw.odk.spring6.entity.Order;

public interface EmployeeProjection {
	String getLastName();
	String getFirstName();
	List<Order> getOrders();
}
