package tw.odk.spring10.dto;

import lombok.Data;

@Data
public class ChatMessage {
	private String account;
	private String content;
	private String time; 
}
