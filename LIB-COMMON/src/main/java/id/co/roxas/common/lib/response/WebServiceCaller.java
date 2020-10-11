package id.co.roxas.common.lib.response;

import java.io.BufferedReader;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WebServiceCaller {

	public static CloseableHttpClient createAcceptSelfSignedCertificateClientII()
	{
	    CloseableHttpClient httpClient = null;
	    try {
	        httpClient = HttpClients.custom().
	                setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).
	                setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy()
	                {
	                    public boolean isTrusted(X509Certificate[] arg0, String arg1) throws 
	                    CertificateException
	                    {
	                        return true;
	                    }
	                }).build()).build();
	    } catch (KeyManagementException e) {
	        //LOGGER.error("KeyManagementException in creating http client instance", e);
	    } catch (NoSuchAlgorithmException e) {
	        //LOGGER.error("NoSuchAlgorithmException in creating http client instance", e);
	    } catch (KeyStoreException e) {
	        //LOGGER.error("KeyStoreException in creating http client instance", e);
	    }
	    return httpClient;
	}
	
	@SuppressWarnings("rawtypes")
	public static ResponseEntity<String> wsBody(String url, Object body, HttpMethod method, Map<String,String> headerMap)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		if (headerMap != null) {
			for (Entry<String, String> hm : headerMap.entrySet()) {
				headers.add(hm.getKey(), hm.getValue());
			}
			
		}
		
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(createAcceptSelfSignedCertificateClientII());
		
		@SuppressWarnings("unchecked")
		HttpEntity<String> httpEntity = new HttpEntity(body, headers);
		
		System.err.println("body : " + new Gson().toJson(httpEntity.getBody()));
		System.err.println("header : " + new Gson().toJson(httpEntity.getHeaders()));
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		System.err.println("url yang diberikan : " + url);
		
		ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);
		
		try {
				response = restTemplate.exchange(url, method, httpEntity, String.class);
		}catch (HttpClientErrorException exp) {
			if (Strings.isEmpty(exp.getResponseBodyAsString())) {
				response = new ResponseEntity<String>(exp.getMessage(), exp.getStatusCode());
			} else {
				response = new ResponseEntity<String>(exp.getResponseBodyAsString(), exp.getStatusCode());
			}
		} catch (HttpServerErrorException exp) {
			if (Strings.isEmpty(exp.getResponseBodyAsString())) {
				response = new ResponseEntity<String>(exp.getMessage(), exp.getStatusCode());
			} else {
				response = new ResponseEntity<String>(exp.getResponseBodyAsString(), exp.getStatusCode());
			}
		}
		
		return response;
	}
}
