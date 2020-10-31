package id.co.roxas.management.ui.web.controller.department;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.roxas.common.lib.dto.user_mgmt.department.TblDepartmentMgmtDto;
import id.co.roxas.common.lib.helper.PagingMeClz;
import id.co.roxas.common.lib.mapper.MapperJson;
import id.co.roxas.common.lib.response.WebServiceCaller;
import id.co.roxas.management.ui.web.controller.BaseCtl;

@RestController
@RequestMapping("/departmentMenuSvcCtl")
public class DepartmentMenuSvcCtl extends BaseCtl{

	@GetMapping("/getDatasPaging")
	public ResponseEntity<Object> getDatasPaging(
			@RequestHeader("token") String token,
			@RequestParam(value="page", required = true) Integer page,
			@RequestParam(value="sort", required = true) String sort){
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Authorization", "Bearer " + token);
		ResponseEntity<String> response = WebServiceCaller.wsBody
				(PATH_CORE_PROJECT+"/departmentMgmtCoreCtl/pagingListDepartment?"
						+ "page="+page+"&size="+Total10+"&sort="+sort,
						null, HttpMethod.GET, headerMap);
		
		return new ResponseEntity<Object>(response.getBody(), response.getStatusCode());
	}

	@PostMapping("/saveDepartment")
	public ResponseEntity<Object> saveDepartment(@RequestHeader("token") String token,
			@RequestBody TblDepartmentMgmtDto tblDepartmentMgmtDto
			){
		ResponseEntity<String> response = WebServiceCaller.wsBody
				(PATH_CORE_PROJECT+"/departmentMgmtCoreCtl/saveDepartment",
						tblDepartmentMgmtDto, HttpMethod.POST, headerWithToken(token));
		return new ResponseEntity<Object>(response.getBody(), response.getStatusCode());
	}
	

	@GetMapping("/getDepartmentByCode/{departmentCode}")
	public ResponseEntity<Object> getDepartmentByCode(
			@RequestHeader("token") String token,
			@PathVariable(name = "departmentCode",required = true) String departmentCode){
		ResponseEntity<String> response = WebServiceCaller.wsBody
				(PATH_CORE_PROJECT+"/departmentMgmtCoreCtl/getDepartmentByCode/"+departmentCode,
						null, HttpMethod.GET, headerWithToken(token));
		return new ResponseEntity<Object>(response.getBody(), response.getStatusCode());
	}
	
	@PutMapping("/updateDepartment")
	public ResponseEntity<Object> updateDepartment(@RequestHeader("token") String token,
			@RequestBody TblDepartmentMgmtDto tblDepartmentMgmtDto
			){
		ResponseEntity<String> response = WebServiceCaller.wsBody
				(PATH_CORE_PROJECT+"/departmentMgmtCoreCtl/updateDepartment",
						tblDepartmentMgmtDto, HttpMethod.PUT, headerWithToken(token));
		return new ResponseEntity<Object>(response.getBody(), response.getStatusCode());
	}
	
	@DeleteMapping("/deleteDepartment/{departmentCode}")
	public ResponseEntity<Object> deleteDepartment(
			@RequestHeader("token") String token,
			@PathVariable("departmentCode") String departmentCode){
		ResponseEntity<String> response = WebServiceCaller.wsBody
				(PATH_CORE_PROJECT+"/departmentMgmtCoreCtl/deleteDepartment/"+departmentCode,
						null, HttpMethod.DELETE, headerWithToken(token));
		return new ResponseEntity<Object>(response.getBody(), response.getStatusCode());
	}
}
