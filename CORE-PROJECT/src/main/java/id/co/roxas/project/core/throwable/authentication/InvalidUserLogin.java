package id.co.roxas.project.core.throwable.authentication;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

public class InvalidUserLogin extends OAuth2Exception {
	private static final long serialVersionUID = 6256653607243272509L;
	private String oAuth2ErrorCode;
	private int httpErrorCode;
	private Map<String, String> additionalInfo = new HashMap<>();
	
	public InvalidUserLogin(String msg,String oAuth2ErrorCode,HttpStatus httpErrorCode, Map<String, String> additionalInfo) {
		super(msg);
		this.httpErrorCode = httpErrorCode.value();
		this.oAuth2ErrorCode = oAuth2ErrorCode;
		this.additionalInfo = additionalInfo;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getHttpErrorCode() {
		return this.httpErrorCode;
	}
	
	@Override
	public String getOAuth2ErrorCode() {
		return this.oAuth2ErrorCode;
	}
	
	@Override
	public Map<String, String> getAdditionalInformation() {
		return this.additionalInfo;
	}
	

}