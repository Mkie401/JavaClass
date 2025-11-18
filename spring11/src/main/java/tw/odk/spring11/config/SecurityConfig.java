package tw.odk.spring11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
//		httpSecurity.authorizeHttpRequests(new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//			
//			@Override
//			public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry t) {
//				t.requestMatchers(("/login")
//			}
//		});
		
		httpSecurity.authorizeHttpRequests(
				auth -> auth.requestMatchers("/login","/css?**","/img/**","/page403").permitAll()
							.requestMatchers("/admin/**").hasRole("ADMIN")
							.requestMatchers("/main/**").hasAnyRole("ADMIN", "USER")
							.anyRequest()
							.authenticated())
		.formLogin(
			form -> form.loginPage("/login")
						.usernameParameter("account")
						.passwordParameter("passwd")
						.loginProcessingUrl("/doLogin")
						.defaultSuccessUrl("/main")
						.failureUrl("/login?error")
						.permitAll())
		.logout(
			logout -> logout.logoutUrl("/logout")
							.logoutSuccessUrl("/login?logout")
							.invalidateHttpSession(true)
							.deleteCookies("JSESSIONID"))
		.exceptionHandling(ex -> ex.accessDeniedPage("/page403"))
		;
		
		
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
