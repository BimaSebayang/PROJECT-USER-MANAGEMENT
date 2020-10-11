package id.co.roxas.common.lib.dto.oauth;

import java.util.Date;
import java.util.Map;

public class OauthTokenResponse {

	private String access_token;
	private String token_type;
	private Long expires_in;
	private String scope;
	private Map<String, Object> access_by;
	private Date access_time;
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public Long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public Map<String, Object> getAccess_by() {
		return access_by;
	}
	public void setAccess_by(Map<String, Object> access_by) {
		this.access_by = access_by;
	}
	public Date getAccess_time() {
		return access_time;
	}
	public void setAccess_time(Date access_time) {
		this.access_time = access_time;
	}
	
	
	
}
