package tw.odk.spring11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tw.odk.spring11.entity.Member;
import tw.odk.spring11.repo.MemberRepo;

@Service
public class MemberService implements UserDetailsService{
	@Autowired
	private  MemberRepo repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = repo.findByAccount(username).orElse(null);
		if (member == null) throw new UsernameNotFoundException("Member NOT FOUND");
		
		
		return User.builder()
				.username(member.getAccount())
				.password(member.getPasswd())
				.roles(member.getRole())
				.build();
	}
	
}
