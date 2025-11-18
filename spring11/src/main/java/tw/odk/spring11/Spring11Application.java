package tw.odk.spring11;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import tw.odk.spring11.entity.Member;
import tw.odk.spring11.repo.MemberRepo;

@SpringBootApplication
public class Spring11Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring11Application.class, args);
	}
	// 啟動時 建立 admin /123456 / ADMIN ((如果沒有時)
	@Bean
	CommandLineRunner init(MemberRepo repo, PasswordEncoder encoder) {
		CommandLineRunner cmd = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				if (repo.findByAccount("admin").isEmpty()) {
					Member member = new Member();
					member.setAccount("admin");
					member.setPasswd(encoder.encode("123456"));
					member.setName("管理員");
					member.setRole("ADMIN");
					repo.save(member);
					
					
				}
			}
		};
		
		return cmd;
	}
	
	
}
