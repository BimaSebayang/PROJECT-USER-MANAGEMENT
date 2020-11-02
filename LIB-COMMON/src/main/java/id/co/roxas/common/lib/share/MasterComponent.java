package id.co.roxas.common.lib.share;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public abstract class MasterComponent {
	
	protected static final Integer ERROR_1 = 1;
	protected static final Integer ERROR_2 = 2;
	protected static final Integer SUCCESS_3 = 3;
	protected static final Integer ERROR_4 = 4;
	protected static final Integer ERROR_5 = 5;
	protected static final Integer SUCCESS_6 = 6;
	protected static final Integer SUCCESS_7 = 7;
	public static final String FORMAT_DATE_V1="dd/MM/yyyy HH:mm:ss";
	public static final String TIMEZONE_V1="GMT+7";
	
	protected MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();

	protected Boolean isThereisWhiteSpace(String word) {
		for (char s : word.toCharArray()) {
			if (Character.isWhitespace(s)) {

				return true;
			}
		}
		return false;
	}

	protected Map<String, Object> validationWordingCheck(String reason, String message, Integer code) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("error", reason);
		map.put("error_description", message);
		map.put("code", code);
		return map;
	}

	protected Map<String, Object> successResponseCheck(Object result, String message, Integer code) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("message", message);
		map.put("code", code);
		return map;
	}
	
	protected String getSaltString(Integer length) {
      
        
        String[] saltResult = new String[length];
        String resultSalt = "";
        for(int i = 0 ; i<saltResult.length;i++) {
        	String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            StringBuilder salt = new StringBuilder();
            Random rnd = new Random();
        	while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        	}
        	resultSalt += salt.toString();
        	
        	if(i!=saltResult.length-1) {
        		resultSalt += "-";
        	}
        }
       
        return resultSalt;

    }
	
}
