package Project.Backend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import Project.Backend.services.UDS;
import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	// application.properties에서 불러오기, 변경될 일이 거의 없는 고정값들
	@Value("${csrf.ignore.path}")
	String csrf_ignore;
	
	@Value("${login.page.path}")
	String login_page;
	
	@Value("${login.process.path}")
	String login_process;
	
	@Value("${login.username}")
	String username;
	
	@Value("${login.password}")
	String password;
	
	@Value("${login.success.path}")
	String login_success;
	
	@Value("${login.failure.path}")
	String login_failure;
	
	@Value("${login.logout.path}")
	String login_logout;
	
	@Value("${login.logout.redirect.path}")
	String login_logout_redirect;
	
	@Autowired
	UDS userdetailsservice;
	
	@Bean
	public SecurityFilterChain register(HttpSecurity http) throws Exception {
		http
			.csrf(target->
				target
					.ignoringRequestMatchers(csrf_ignore)	// 페이지가 아닌 api를 받아온다
			)
			.authorizeHttpRequests(target->
				target
					.dispatcherTypeMatchers(DispatcherType.FORWARD)
					.permitAll()
					.requestMatchers("/경로/**", "/경로/**")	// 로그인이 필요한 경우
					.authenticated()
					.requestMatchers("/경로/**")	// 권한이 필요한 경우
					.hasAnyRole("권한1", "권한2")	
					.anyRequest()
					.permitAll()
			)
			.formLogin(target->
				target
					.loginPage(login_page)
					.loginProcessingUrl(login_process)
					.usernameParameter(username)
					.passwordParameter(password)
					.successForwardUrl(csrf_ignore)
					.failureUrl(login_failure)
					.permitAll()
			)
			.logout(target->
				target
					.clearAuthentication(true)
					.deleteCookies("삭제할", "쿠키", "이름들")
					.invalidateHttpSession(true)
					.logoutUrl(login_logout)
					.logoutSuccessUrl(login_logout_redirect)
			)
			.oauth2Login(target->
				target
					.userInfoEndpoint(endpointTarget->
						endpointTarget
						.userService(userdetailsservice)
					)
					.permitAll()
			)
			;
		
		return http.getOrBuild();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();	// 비밀번호 암호화
//		return new NoOpPasswordEncoder();	// 암호화를 하고 싶지 않다면
	}
}
