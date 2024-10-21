package Project.Backend.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import Project.Backend.classes.UD;
import Project.Backend.entity.User;
import Project.Backend.repository.UserRepository;


// user service와 oauth2user service를 합쳐서 작성

@Service
public class UDS extends DefaultOAuth2UserService implements UserDetailsService {
	
	@Autowired
	UserRepository userRep;
	
	@Value("${auth.user}")
	String userAuth;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User user = super.loadUser(userRequest);
		String provider = userRequest.getClientRegistration().getRegistrationId();
		Map<String, Object> response = null;
		String id = "무작위 아이디값";
		
		// ---------------- 직접 수정해야할 영역 ------------------------
		if(provider.equals("google") || provider.equals("facebook")) {
			
		} else if(provider.equals("naver")) {
			response = (Map<String,Object>)user.getAttributes().get("response");
			id = provider + "_" + "무작위 ID값";
		}
		// ---------------------------------------------------------
		
		User userByName = userRep.findByName(id);
		if(userByName == null) {
			userRep.save(new User(0L, id, "무작위 아무값", List.of(userAuth), response));
		}
		return new UD(userByName);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRep.findByName(username);	// 숫자 포함시 인식불가
		if(user == null) throw new UsernameNotFoundException(username);
		
		return new UD(user);
	}
	
}
