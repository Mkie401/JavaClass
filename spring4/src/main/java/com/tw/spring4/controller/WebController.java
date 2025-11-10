package com.tw.spring4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * request -> Controller(Model) -> Model 網頁所需要的資料
 * 			-> View(Resolver) Thymeleaf -> HTML -> Response
 * 
 * request -> RestController(return String(Web Page Content) OR ResponseEntity.ok(物件)JSON
 */


@Controller
@RequestMapping("/")
public class WebController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";  //templates => index.html
	}
	
	@RequestMapping("/member/index")
	public String memberIndex() {
		return "member/index";  // templates => member/index.html
	}
	
	@RequestMapping("/page1")
	public String page1(Model model) {
		model.addAttribute("username", "ODK");
		model.addAttribute("companyName", "123");
		
		
		return "page1";
	}
	
}
