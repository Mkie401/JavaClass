package tw.odk.spring10.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import tw.odk.spring10.dto.ChatMessage;

@Controller
public class ChatController {

	private static final DateTimeFormatter fmt = 
			DateTimeFormatter.ofPattern("HH:mm:ss"); 
	
	@MessageMapping("/chat/send")		// => /app/chat/send
	@SendTo("/topic/public")
	public ChatMessage handleChat(String content, Principal principal) {
		String account = principal.getName();
		
		ChatMessage mesg = new ChatMessage();
		mesg.setAccount(account);
		mesg.setContent(content);
		mesg.setTime(LocalDateTime.now().format(fmt));
		
		return mesg;
	}
	
	
}