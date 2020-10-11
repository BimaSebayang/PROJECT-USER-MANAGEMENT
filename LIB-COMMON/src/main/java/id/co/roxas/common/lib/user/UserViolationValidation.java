package id.co.roxas.common.lib.user;

import java.util.Map;

import org.springframework.http.HttpStatus;
public class UserViolationValidation {
	private String msg;
	private String oAuth2ErrorCode;
	private HttpStatus httpErrorCode;
	private Map<String, String> additionalInfo;
    private boolean isViolation = false;
    
    
	
	public boolean isViolation() {
		return isViolation;
	}

	public void setViolation(boolean isViolation) {
		this.isViolation = isViolation;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getoAuth2ErrorCode() {
		return oAuth2ErrorCode;
	}

	public void setoAuth2ErrorCode(String oAuth2ErrorCode) {
		this.oAuth2ErrorCode = oAuth2ErrorCode;
	}

	public HttpStatus getHttpErrorCode() {
		return httpErrorCode;
	}

	public void setHttpErrorCode(HttpStatus httpErrorCode) {
		this.httpErrorCode = httpErrorCode;
	}

	public Map<String, String> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map<String, String> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

}
