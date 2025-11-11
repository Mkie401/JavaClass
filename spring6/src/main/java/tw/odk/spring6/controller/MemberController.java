package tw.odk.spring6.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import tw.odk.spring6.entity.Member;
import tw.odk.spring6.entity.Profile;
import tw.odk.spring6.repository.MemberRepository;
import tw.odk.spring6.service.MemberProfileService;

@RequestMapping("/member")
@RestController
public class MemberController {
	@Autowired
	private MemberProfileService service;
	
	/*
	 * POST /member/add
	 * {
	 * 		"email" : "test@email.tw",
	 * 		"passwd" : "123456",
	 * 		"profile" : {
	 * 					"cname" : "test",
	 * 					"age" : 18
	 * 					}					
	 */
	
	
	
	@PostMapping("/add")
	public ResponseEntity test1(@RequestBody Map<String, Object> data) {
		Member member = new Member();
		member.setEmail((String)data.get("email"));
		member.setPasswd((String)data.get("passwd"));
		
		Profile profile = null;
		Map<String, Object> pDate = (Map<String,Object>)data.get("profile");
		if(pDate != null) {
			profile = new Profile();
			profile.setCname((String)pDate.get("cname"));
			profile.setAge((Integer)pDate.get("age"));
		}
		member.setProfile(profile);
		Member saveMember = service.save(member, profile);
		
		return ResponseEntity.ok(saveMember);
	}
	
	
	@PostMapping("/{id}/profile")
	public ResponseEntity<Profile> addProfile(
			@PathVariable Long id, @RequestBody Map<String, Object> data) {
		
		Profile profile = new Profile();
		profile.setCname((String)data.get("cname"));
		profile.setAge((Integer)data.get("age"));
		
		Profile saveProfile = service.setProfile2Member(profile, id);
		
		
		return ResponseEntity.ok(saveProfile);
	}
	
	
	@GetMapping("/query/{id}")
	public ResponseEntity<Member> queryMember(@PathVariable Long id) {
		return ResponseEntity.ok(service.findMemberById(id));
	}
	
}
