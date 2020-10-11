package id.co.roxas.project.core.config.auth;


import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		System.err.println("lewat sini kagak sih");
		http.authorizeRequests().antMatchers(
				
				"/api/oauth/token",
				"/swagger-ui",
				//swagger config freedom --start
				"/swagger-ui.js",
				"/swagger-ui.min.js", "/api-docs", "/swagger-ui.html", "/fonts/*", "/api-docs/*",
				"/api-docs/default/*", "/o2c.html", "index.html", "/webjars/**", "/hystrix/**",
				"**/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**","/images/*", "/css/*", "/swagger-ui.js",
				"/swagger-ui.min.js", "/api-docs/**", "/swagger-ui.html", "/fonts/*", "/o2c.html", "index.html",
				"/webjars/**", "/hystrix/**","/configuration/security",
				"/swagger-resources/**", "/swagger-ui.html", "/v2/**", "/webjars/**",
				//swagger config freedom --end
				"/eureka", "/eureka/**", "/core-project/cuman-testing/hai").permitAll()
				.anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.ALWAYS).maximumSessions(1) // (1)
				.sessionRegistry(sessionRegistry()); // (4)
	}

	
	@Bean
	SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

}