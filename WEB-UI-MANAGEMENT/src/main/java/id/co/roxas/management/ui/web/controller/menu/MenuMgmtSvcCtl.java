package id.co.roxas.management.ui.web.controller.menu;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.roxas.common.lib.response.WebServiceCaller;
import id.co.roxas.management.ui.web.controller.BaseCtl;

@RestController
@RequestMapping("/menuMgmtSvcCtl")
public class MenuMgmtSvcCtl extends BaseCtl{
	
	@GetMapping("/pagingListMenu")
	public ResponseEntity<Object> getDatasPaging(
			@RequestHeader("token") String token,
			@RequestParam(value="page", required = true) Integer page,
			@RequestParam(value="sort", required = true) String sort){
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Authorization", "Bearer " + token);
		ResponseEntity<String> response = WebServiceCaller.wsBody
				(PATH_CORE_PROJECT+"/menuMgmtCoreCtl/pagingListMenu?"
						+ "page="+page+"&size="+Total10+"&sort="+sort,
						null, HttpMethod.GET, headerMap);
		
		return new ResponseEntity<Object>(response.getBody(), response.getStatusCode());
	}
	
}
