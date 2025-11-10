package tw.odk.spring5.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import tw.odk.spring5.dto.MemberForm;
import tw.odk.spring5.entity.Hotel;
import tw.odk.spring5.entity.Member;
import tw.odk.spring5.repository.HotelRepository;
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
			return "redirect:/member/login";
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("error", "帳號重複");
			return "register";
		}
	}
	
	@PostMapping("/register2")
	public String doRegister2(@RequestParam String account,
			@RequestParam String passwd,
			@RequestParam String name,
			@RequestParam MultipartFile iconFile) {
		
		return "success";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String doLogin(Model model, 
			@RequestParam String account, 
			@RequestParam String passwd, 
			HttpSession session) {
		Member member = memberService.login(account, passwd);
		if (member != null) {
			session.setAttribute("member", member);
			return "redirect:/member/home";
		}
		return "login";
	}
	
	
	@Autowired
	private HotelRepository hotelRepository;
	
	
	
	@RequestMapping("/home")
	public String home(Model model,HttpSession session,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		
		Member member = (Member)session.getAttribute("member");
		if(member == null) {
			return "redirect:/member/login";
		}
		
		model.addAttribute("member", member);
		model.addAttribute("icon", Base64.getEncoder().encodeToString(member.getIcon()));
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Hotel> pageHotel = hotelRepository.findAll(pageable);
		
		model.addAttribute("hotelPage", pageHotel);
		model.addAttribute("page", page);
		
		
		return "home";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/logout";
	}
	
	
	
	
}