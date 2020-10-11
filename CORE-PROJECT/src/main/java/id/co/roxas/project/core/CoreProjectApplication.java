package id.co.roxas.project.core;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import id.co.roxas.common.lib.user.UserDetail;
import id.co.roxas.project.core.config.auth.CustomUserService;
import id.co.roxas.project.core.throwable.authentication.InvalidUserLogin;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"id.co.roxas"})
@EnableAutoConfiguration
@EnableSwagger2
public class CoreProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreProjectApplication.class, args);
	}
	

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		builder.userDetailsService(new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String userValidation) throws UsernameNotFoundException {
				
			
			    
			    String password = request.getParameter("password");
                System.err.println("pass nya : " + password);
				UserDetail userDetail = new UserDetail();
				userDetail.setUserName(userValidation);
				userDetail.setUserPassword("PASS");
				userDetail.setAccountNonExpired(true);
				userDetail.setAccountNonLocked(true);
				userDetail.setCredentialsNonExpired(true);
				userDetail.setEnabled(true);
				
				getValidationUserDetail(userDetail);
				
				
				return new CustomUserService(userDetail);
			}
		});
	}
	
	
	//disini untuk validasi user
		private final void getValidationUserDetail(UserDetail userValidation) {

			if (userValidation.getUserName().equals("Bima")) {
				Map<String, String> info = new HashMap<String, String>();
				info.put("code", "RUV");
				throw new InvalidUserLogin(userValidation.getUserName() + " tidak dapat melakukan login ke sini",
						"Restricted User", HttpStatus.FORBIDDEN, info);
			} else if (userValidation.getUserName().equals("Bimas")) {
				Map<String, String> info = new HashMap<String, String>();
				info.put("code", "LUV");
				throw new InvalidUserLogin(userValidation.getUserName() + " telah di locked", "Locked User", HttpStatus.LOCKED,
						info);
			} else if (userValidation.getUserName().equals("Bimass")) {
				Map<String, String> info = new HashMap<String, String>();
				info.put("code", "NFUV");
				throw new InvalidUserLogin(userValidation.getUserName() + " tidak dapat ditemukan", "Not Found User",
						HttpStatus.NOT_FOUND, info);
			}
	}

}
