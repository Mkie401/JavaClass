package com.tw.spring4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ApiController {
	
	@RequestMapping("/hello")
	public String index() {
		return "Hello API";
	}
}
