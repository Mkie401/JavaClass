package tw.odk.spring10.config;


import java.security.Principal;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import jakarta.servlet.http.HttpServletRequest;
import tw.odk.spring10.util.JwtTool;
@Configuration
@EnableWebSocketMessageBroker
public class MyWebSocketConfig implements WebSocketMessageBrokerConfigurer{
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws-chat")
				.addInterceptors(Interceptor())
				.setAllowedOriginPatterns("*")
				.setHandshakeHandler(new DefaultHandshakeHandler() {
					@Override
					protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler,
							Map<String, Object> attributes) {
						String account = (String)attributes.get("account");
						
						Principal principal = new Principal() {
							@Override
							public String getName() {
								return account;
							}
						};
						
						return principal;
					}
					
				})
				.withSockJS();
				
	}
	
	// 交握攔截器
	private HandshakeInterceptor Interceptor() {
		HandshakeInterceptor interceptor = new HandshakeInterceptor() {
			// 檢查 token
			@Override
			public boolean beforeHandshake(ServerHttpRequest request, 
					ServerHttpResponse response, WebSocketHandler wsHandler,
					Map<String, Object> attributes) throws Exception {

//					HttpServletRequest httpReq = (HttpServletRequest)request;
//					
//					String tokenParam = httpReq.getParameter("token");
//					if (tokenParam != null && tokenParam.startsWith("Bearer ")) {
//						String token = tokenParam.substring(7);
//						if (token != null && JwtTool.isValid(token)) {
//							String account = JwtTool.fetchAccount(token);
//							attributes.put("account", account);
//							return true;
//						}
//					}
				
				
				if (request instanceof ServletServerHttpRequest req) {
					HttpServletRequest httpReq = req.getServletRequest();
					
					String tokenParam = httpReq.getParameter("token");
					if (tokenParam != null && tokenParam.startsWith("Bearer ")) {
						String token = tokenParam.substring(7);
						if (token != null && JwtTool.isValid(token)) {
							String account = JwtTool.fetchAccount(token);
							attributes.put("account", account);
							return true;
						}
					}
				}
				
				return false;
			}
			
			@Override
			public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
					Exception exception) {
				
			}
		};
		return interceptor;
	}



}