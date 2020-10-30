package id.co.roxas.management.ui.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import id.co.roxas.common.lib.share.MasterComponent;

@Component
public abstract class BaseCtl extends MasterComponent{
	protected static final Integer Total10 = 10;
    protected static final String TOKEN_COOKIES = "token-cookies";
    protected static final String PATH_CORE_PROJECT = "http://localhost:38081";
    protected static final String BASIC_OAUTH = "Basic bXktdHJ1c3RlZC1zZXJ2aWNlLW5laWdoYm91cmhvb2Q6bGFja2luZzAzMDlOZWlnaGJvdXI=";
    protected static final String TOPIC = "/topic/";
    protected static final String APP="/app";
    protected static final String TRANSACTION="/transaction";
   public Map<String, String> headerWithToken(String token){
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Authorization", "Bearer " + token);
		return headerMap;
   }
}
