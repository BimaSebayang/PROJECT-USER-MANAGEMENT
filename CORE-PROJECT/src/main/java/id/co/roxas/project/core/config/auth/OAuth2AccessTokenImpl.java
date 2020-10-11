package id.co.roxas.project.core.config.auth;


import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.TokenRequest;

public class OAuth2AccessTokenImpl implements OAuth2AccessToken{

	@Override
	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getScope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OAuth2RefreshToken getRefreshToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTokenType() {
		// TODO Auto-generated method stub
		return "bearer";
	}

	@Override
	public boolean isExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Date getExpiration() {
		// TODO Auto-generated method stub
		return new Date();
	}

	@Override
	public int getExpiresIn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "hahaha";
	}

}