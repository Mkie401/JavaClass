package com.tw.spring4.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tw.spring4.test.User;
import com.tw.spring4.test.UserForm;

import jakarta.validation.Valid;

/*
 * request -> Controller(Model) -> Model 網頁所需要的資料
 * 			-> View(Resolver) Thymeleaf -> HTML -> Response
 * 
 * request -> RestController(return String(Web Page Content) OR ResponseEntity.ok(物件)JSON
 */


@Controller
@RequestMapping("/")
public class WebController {

    private final ApiController apiController;

    WebController(ApiController apiController) {
        this.apiController = apiController;
    }
	
	@RequestMapping("/index")
	public String index() {
		return "index";		// templates => index.html
	}
	@RequestMapping("/member/index")
	public String memberIndex() {
		return "member/index";	// templates => member/index.html
	}
	@RequestMapping("/page1")
	public String page1(Model model) {
		model.addAttribute("companyName", "Brad Big Company");
		model.addAttribute("username", "Brad");
		
		User user = new User();
		//user.setId(123);
		user.setName("Peter");
		user.setGender(true);
		user.setAge(17);
		model.addAttribute("user", user);
		
		System.out.println(user);
		
		String now = LocalDateTime.now().format(
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		model.addAttribute("now", now);
		
		return "page1";
	}
	
	@RequestMapping("/page2/{status}")
	public String page2(Model model, @PathVariable String status) {
		model.addAttribute("status", status);
		return "page2";
	}
	
	@GetMapping("/page3")
	public String page3(Model model) {
		//System.out.println("page3");
		model.addAttribute("userForm", new UserForm());
		return "page3";
	}
	
	@PostMapping("/page3")
	public String page3(Model model,
			@ModelAttribute @Valid UserForm userForm,
			BindingResult bindResult) {
		//System.out.println("page3-1");
		if (bindResult.hasErrors()) {
			return "page3";
		}
		// 處理
		System.out.println(userForm.getEmail());
		return "page4";
	}
	
	
}