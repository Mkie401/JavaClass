package tw.odk.spring5.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tw.odk.spring5.dto.MemberForm;
import tw.odk.spring5.entity.Member;
import tw.odk.spring5.repository.MemberRepository;
import tw.odk.spring5.util.BCrypt;

@Service
public class MemberService {
	@Autowired
	private MemberRepository repository;
	
	public Member register(MemberForm memberForm) throws Exception {
		
		Member member = new Member();
		String account = memberForm.getAccount();
		if (repository.findByAccount(account) != null) throw new Exception();
		member.setAccount(account);
		member.setPasswd(BCrypt.hashpw(memberForm.getPasswd(), BCrypt.gensalt()));
		member.setName(memberForm.getName());
		
		MultipartFile iconFile = memberForm.getIconFile();
		byte[] icon = iconFile != null && !iconFile.isEmpty() ? iconFile.getBytes(): null; 
		member.setIcon(icon);
		
		
		return repository.save(member);
	}
	
	public Member register2(
			String account, 
			String passwd, 
			String name, 
			MultipartFile iconFile) {
		return null;
	}
	
}
