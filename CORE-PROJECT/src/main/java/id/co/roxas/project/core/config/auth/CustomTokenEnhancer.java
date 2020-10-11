package id.co.roxas.project.core.config.auth;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

public class CustomTokenEnhancer extends JwtAccessTokenConverter{

	
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
    	
    	 accessToken = super.enhance(accessToken, authentication);
    	 final Map<String, Object> additionalInfo = new HashMap<>();
    	 if(authentication.getPrincipal() instanceof CustomUserService) {
    	 CustomUserService customUserService = (CustomUserService) authentication.getPrincipal();	 
    	 additionalInfo.put("access_by", customUserService.getUserDetail());
    	 }
    	 additionalInfo.put("access_time", new Date());
    	 ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		 
    	 return accessToken;
    }

}