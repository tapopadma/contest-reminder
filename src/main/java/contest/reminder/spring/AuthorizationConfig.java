package contest.reminder.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorizationConfig {

	@Bean
	public OAuthStorage oAuthStorage() {
		return new OAuthStorage();
	}
}
