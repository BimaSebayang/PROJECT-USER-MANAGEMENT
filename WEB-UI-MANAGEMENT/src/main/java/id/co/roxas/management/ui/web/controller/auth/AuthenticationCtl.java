package id.co.roxas.management.ui.web.controller.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import id.co.roxas.common.lib.user.UserMenu;
import id.co.roxas.common.lib.user.UserViolationValidation;
import id.co.roxas.management.ui.web.controller.BaseCtl;

@RestController
@RequestMapping("/authenticationCtl")
public class AuthenticationCtl extends BaseCtl {

	@PutMapping("/loginOauth")
	public ResponseEntity<Object> loginOauth(@RequestBody OauthTokenRequest oauthTokenRequest) throws InterruptedException{
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Authorization", BASIC_OAUTH);
		ResponseEntity<String> response = WebServiceCaller.wsBody
				(PATH_CORE_PROJECT+"/oauth/token?username="+oauthTokenRequest.getUserId()+
						"&password="+oauthTokenRequest.getUserPassword()
						+"&grant_type=password", null, HttpMethod.POST, headerMap);
		//TimeUnit.MILLISECONDS.sleep(1000);
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
	
	@GetMapping("/getAllMenu")
	public ResponseEntity<Object> getAllMenu(@RequestHeader("token") String token){
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Authorization", "Bearer " + token);
		ResponseEntity<String> response = WebServiceCaller.wsBody(PATH_CORE_PROJECT + "/auth/getAllMenu/ByMyAuth", null,
				HttpMethod.GET, headerMap);
		return new ResponseEntity<Object>(response.getBody(), response.getStatusCode());
	}
	
	@GetMapping("/checkMyAuth")
	public ResponseEntity<Object> userHeader(
			@RequestHeader("accessTo") String accessTo,
			@RequestHeader("token") String token) throws InterruptedException {
		System.out.println("accessto : " + accessTo);
		System.out.println("token : " + token);
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Authorization", "Bearer " + token);
		ResponseEntity<String> response = WebServiceCaller.wsBody(PATH_CORE_PROJECT + "/auth/getAllMenu/ByMyAuth", null,
				HttpMethod.GET, headerMap);

		System.err.println(response.getBody());
		
		UserHeader header = new UserHeader();
		
		if (response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
			UserViolationValidation violationValidation = new UserViolationValidation();
			violationValidation.setViolation(true);
			header.setViolation(violationValidation);
			//TimeUnit.MILLISECONDS.sleep(1000);
			return new ResponseEntity<Object>(header, HttpStatus.UNAUTHORIZED);
		}else if(response.getStatusCode() == HttpStatus.OK) {
			UserViolationValidation violationValidation = new UserViolationValidation();
			violationValidation.setViolation(false);
			header.setViolation(violationValidation);
			List<UserMenu> userMenus = new ArrayList<UserMenu>();
			try {
				userMenus = MapperJson.mapperJsonToListDto(response.getBody(), UserMenu.class);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			header.setMenuViolation(!userMenus.stream().anyMatch(menu->menu.getUrlMenu().equals(accessTo)));
			//TimeUnit.MILLISECONDS.sleep(1000);
			
			return new ResponseEntity<Object>(header, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
//	@GetMapping("/checkMyAuth")
//	public ResponseEntity<UserHeader> userHeader(@RequestHeader("token") String token) throws InterruptedException {
//		System.out.println("token : " + token);
//		Map<String, String> headerMap = new HashMap<>();
//		headerMap.put("Authorization", "Bearer " + token);
//		ResponseEntity<String> response = WebServiceCaller.wsBody(PATH_CORE_PROJECT + "/auth/checkAuth", null,
//				HttpMethod.GET, headerMap);
//
//		UserHeader header = new UserHeader();
//		if (response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
//			UserViolationValidation violationValidation = new UserViolationValidation();
//			violationValidation.setViolation(true);
//			header.setViolation(violationValidation);
//			//TimeUnit.MILLISECONDS.sleep(1000);
//			return new ResponseEntity<UserHeader>(header, HttpStatus.UNAUTHORIZED);
//		}else if(response.getStatusCode() == HttpStatus.OK) {
//			UserViolationValidation violationValidation = new UserViolationValidation();
//			violationValidation.setViolation(false);
//			header.setViolation(violationValidation);
//			//TimeUnit.MILLISECONDS.sleep(1000);
//			
//			return new ResponseEntity<UserHeader>(header, HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}

}
