package tw.odk.spring5.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberForm {
	private String name;
	private String account;
	private String passwd;
	private MultipartFile iconFile;
	
}
