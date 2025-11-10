package tw.odk.spring5.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.odk.spring5.dto.MemberForm;
import tw.odk.spring5.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("memberForm", new MemberForm());
		return "register";
	}
	
	@GetMapping("/register2")
	public String register2() {
		return "register2";
	}
	
	@PostMapping("/register")
	public String doRegister(@ModelAttribute MemberForm memberForm, Model model) {
		try {
			memberService.register(memberForm);
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("error", "帳號重複");
			return "register";
		}
	
		
		return "success";
	}
	
	@PostMapping("/register2")
	public String doRegister2(@RequestParam String account,
			@RequestParam String passwd,
			@RequestParam String name,
			@RequestParam MultipartFile iconFile) {
		
		return "success";
	}
	
}