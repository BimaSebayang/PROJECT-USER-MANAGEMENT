package id.co.roxas.management.ui.web.controller.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import id.co.roxas.common.lib.dto.oauth.OauthTokenRequest;
import id.co.roxas.common.lib.dto.oauth.OauthTokenResponse;
import id.co.roxas.common.lib.mapper.MapperJson;
import id.co.roxas.common.lib.response.WebServiceCaller;
import id.co.roxas.common.lib.user.UserHeader;
import id.co.roxas.common.lib.user.UserViolationValidation;
import id.co.roxas.management.ui.web.controller.BaseCtl;

@RestController
@RequestMapping("/authenticationCtl")
public class AuthenticationCtl extends BaseCtl {

	@PutMapping("/loginOauth")
	public ResponseEntity<Object> loginOauth(@RequestBody OauthTokenRequest oauthTokenRequest){
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Authorization", BASIC_OAUTH);
		ResponseEntity<String> response = WebServiceCaller.wsBody
				(PATH_CORE_PROJECT+"/oauth/token?username="+oauthTokenRequest.getUserId()+
						"&password="+oauthTokenRequest.getUserPassword()
						+"&grant_type=password", null, HttpMethod.POST, headerMap);
		
		if(response.getStatusCode()==HttpStatus.OK) {
			OauthTokenResponse tokenResponse = new OauthTokenResponse();
			try {
				 tokenResponse = MapperJson.mapperJsonToSingleDto
						(response.getBody(), OauthTokenResponse.class);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return new ResponseEntity<Object>(tokenResponse.getAccess_token(),response.getStatusCode());	
		}
		else {
			
			return new ResponseEntity<Object>(MapperJson.mapperJsonToHashMap(response.getBody()),
					 	response.getStatusCode());
		}
		
	}
	
	@GetMapping("/checkMyAuth")
	public ResponseEntity<UserHeader> userHeader(@RequestHeader("token") String token) throws InterruptedException {
		System.out.println("token : " + token);
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Authorization", "Bearer " + token);
		ResponseEntity<String> response = WebServiceCaller.wsBody(PATH_CORE_PROJECT + "/auth/checkAuth", null,
				HttpMethod.GET, headerMap);

		UserHeader header = new UserHeader();
		if (response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
			UserViolationValidation violationValidation = new UserViolationValidation();
			violationValidation.setViolation(true);
			header.setViolation(violationValidation);
			TimeUnit.MILLISECONDS.sleep(1000);
			return new ResponseEntity<UserHeader>(header, HttpStatus.UNAUTHORIZED);
		}else if(response.getStatusCode() == HttpStatus.OK) {
			UserViolationValidation violationValidation = new UserViolationValidation();
			violationValidation.setViolation(false);
			header.setViolation(violationValidation);
			TimeUnit.MILLISECONDS.sleep(1000);
			return new ResponseEntity<UserHeader>(header, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
