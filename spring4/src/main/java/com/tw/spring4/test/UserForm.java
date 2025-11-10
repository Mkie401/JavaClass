package com.tw.spring4.test;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserForm {
	@NotBlank(message= "Email 不可空")
	@Email(message= "輸入有效的Email")
	private String email;
	
}
