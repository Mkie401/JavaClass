package tw.odk.spring6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.odk.spring6.entity.Member;
import tw.odk.spring6.entity.Profile;
import tw.odk.spring6.repository.MemberRepository;
import tw.odk.spring6.repository.ProfileRepository;

@Service
public class MemberProfileService {
	
	@Autowired
	private MemberRepository memberRepo;
	@Autowired
	private ProfileRepository profileRepo;
	
	@Transactional
	public Member save(Member member, Profile profile) {
		member.setProfile(profile);
		return memberRepo.save(member);
	}
	
	
	public Profile setProfile2Member(Profile profile, Long memberId) {
		Member member = memberRepo.findById(memberId).orElse(null);
		if (member != null) {
			Profile p = member.getProfile();
			if(p != null) {
				profile.setId(p.getId());
			}
			member.setProfile(profile);
			
			
			Member saveMember = memberRepo.save(member);
			
			return saveMember.getProfile();
		}
		return null;
	}
	
	public Member findMemberById(Long memberId) {
		return memberRepo.findById(memberId).orElse(null);	
		}
	
}
