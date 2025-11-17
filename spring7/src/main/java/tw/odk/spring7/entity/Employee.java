package tw.odk.spring7.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {
	@Id
	private Integer EmployeeID;
	private String LastName;
	private String FirstName;
	private String Title;
	private String Address;
	private String City;
	private Float Salary; 

}
