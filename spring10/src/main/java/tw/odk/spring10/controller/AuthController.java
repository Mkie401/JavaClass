package tw.odk.spring10.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.odk.spring10.dto.Login;
import tw.odk.spring10.entity.Member;
import tw.odk.spring10.repo.MemberRepository;
import tw.odk.spring10.response.LoginResponse;
import tw.odk.spring10.util.JwtTool;

@RequestMapping("/auth")
@RestController
public class AuthController {
	@Autowired
	private MemberRepository memberRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login) {
		Member member = memberRepository.findByAccount(login.getAccount()).orElse(null);
		if (member == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("帳號不存在");
		}
		
		if (!BCrypt.checkpw(login.getPasswd(), member.getPasswd())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("密碼問題");
		}
		
		String token = JwtTool.createToken(member.getAccount());
		return ResponseEntity.ok(new LoginResponse(token, member.getAccount()));
		
		
		
	}
	
}
