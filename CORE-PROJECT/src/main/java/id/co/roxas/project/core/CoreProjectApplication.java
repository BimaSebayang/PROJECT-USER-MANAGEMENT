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

import com.google.gson.Gson;

import id.co.roxas.common.lib.dto.user_mgmt.custom.TblUserDtlMgmtAll;
import id.co.roxas.common.lib.user.UserDetail;
import id.co.roxas.project.core.config.auth.CustomUserService;
import id.co.roxas.project.core.service.user.GetAllAboutUserSvc;
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
			HttpServletRequest request, GetAllAboutUserSvc getAllAboutUserSvc) throws Exception {
		builder.userDetailsService(new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String userValidation) throws UsernameNotFoundException {
				
				String password = request.getParameter("password");
				TblUserDtlMgmtAll userDtlMgmtAll = getAllAboutUserSvc.getAllInformationOfAUser(userValidation);
			
			    
				getValidationUserDetail(getAllAboutUserSvc,userDtlMgmtAll,userValidation,password);
				
                System.err.println("pass nya : " + password);
				UserDetail userDetail = new UserDetail();
				userDetail.setUserName(userDtlMgmtAll.getTblUserMgmtDtlDto().getUserName());
				userDetail.setUserPassword(userDtlMgmtAll.getTblUserMgmtDto().getPassword());
				userDetail.setAccountNonExpired(!userDtlMgmtAll.getTblUserMgmtDto().getIsPasswordExpired());
				userDetail.setAccountNonLocked(userDtlMgmtAll.getTblUserMgmtDto().getIsAccountActive());
				userDetail.setCredentialsNonExpired(true);
				userDetail.setEnabled(true);
				
				
				
				
				return new CustomUserService(userDetail);
			}
		});
	}
	
	
	//disini untuk validasi user
		private final void getValidationUserDetail(GetAllAboutUserSvc getAllAboutUserSvc,TblUserDtlMgmtAll userDtlMgmtAll,String userValidation, String password) {
			System.err.println("user Detailnya : " + new Gson().toJson(userDtlMgmtAll));
			System.err.println("user validation : " + userValidation + " password : " + password );
			String username = "Username : "+ userValidation;
            if (userDtlMgmtAll.getTblUserMgmtDto().getUserId()==null) {
				Map<String, String> info = new HashMap<String, String>();
				String code = "NFUV";
				info.put("code", code);
				throw new InvalidUserLogin(username + " tidak dapat ditemukan.  ["+code+"]", "Not Found User",
						HttpStatus.NOT_FOUND, info);
			}
            else if(userDtlMgmtAll.getTblUserMgmtDtlDto().getUserDetailId()==null) {
            	Map<String, String> info = new HashMap<String, String>();
				String code = "DNFU";
				info.put("code", code);
				throw new InvalidUserLogin("Detail Informasi " + username + " tidak dapat ditemukan.  ["+code+"]", "Not Found User",
						HttpStatus.NOT_FOUND, info);
            }
            else if (!userDtlMgmtAll.getTblUserMgmtDto().getIsAccountActive()) {
				Map<String, String> info = new HashMap<String, String>();
				String code = "INU";
				info.put("code", code);
				throw new InvalidUserLogin(username+
						" Telah Non Aktif. Mohon ke bagian admin untuk mengaktifkan user Anda kembali. ["+code+"]", "Inactive User", HttpStatus.LOCKED,
						info);
			}
            
            else if (userDtlMgmtAll.getTblUserMgmtDto().getIsPasswordExpired()) {
				Map<String, String> info = new HashMap<String, String>();
				String code = "EPU";
				info.put("code", code);
				throw new InvalidUserLogin("Password "+username+
						" Telah Kadaluarsa. Mohon ke bagian admin untuk memperbaharui password Anda. "
						+ "["+code+"]", "Expired Password User", HttpStatus.FORBIDDEN,
						info);
			}
            
            else if (! userDtlMgmtAll.getTblUserMgmtDto().getPassword().equals(password)) {
       				Map<String, String> info = new HashMap<String, String>();
       				String code = "EPU";
       				info.put("code", code);
       				getAllAboutUserSvc.updateWrongPassword(userValidation);
       				throw new InvalidUserLogin("Password "+username+
       						" Salah. Mohon coba kembali masukkan password Anda. User akan langsung di non aktifkan jika salah melakukan input 3 kali. "
       						+ "["+code+"]", "Wrong Password", HttpStatus.UNAUTHORIZED,
       						info);
       		}
            
           
       
            
	}

}
