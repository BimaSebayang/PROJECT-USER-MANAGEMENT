package id.co.roxas.project.core.controller.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import id.co.roxas.common.lib.dto.user_mgmt.department.TblDepartmentMgmtDto;
import id.co.roxas.project.core.controller.BaseCtl;
import id.co.roxas.project.core.service.department.DepartmentUserMgmtCoreSvc;

@RestController
@RequestMapping("/departmentMgmtCoreCtl")
public class DepartmentMgmtCoreCtl extends BaseCtl{

	@Autowired
	private DepartmentUserMgmtCoreSvc departmentUserMgmtCoreSvc;
	
	@GetMapping("/pagingListDepartment")
	public ResponseEntity<Object> pagingListDepartment(
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "size", required = true) Integer size,
			@RequestParam(value = "sort", required = true) List<String> sorts
			){
		System.err.println("page : " + new Gson().toJson(pageableSetting(page, size, sorts)));
		
		return new ResponseEntity<Object>(departmentUserMgmtCoreSvc.getPageListDepartmen(pageableSetting(page, size, sorts)), HttpStatus.OK);
	}
	
	@PostMapping("/saveDepartment")
	public ResponseEntity<Object> saveDepartment(@RequestBody TblDepartmentMgmtDto tblDepartmentMgmtDto, Authentication authentication){
		ResponseEntity<Object> validity = departmentUserMgmtCoreSvc.validatorSave(tblDepartmentMgmtDto);
		if(validity!=null) {
			return validity;
		}
        
		tblDepartmentMgmtDto = departmentUserMgmtCoreSvc.saveDepartment(tblDepartmentMgmtDto, authentication.getName());
		return new ResponseEntity<Object>(successResponseCheck(tblDepartmentMgmtDto, "Department Berhasil Didaftarkan", 43), HttpStatus.OK);
		
	}
	
	@PutMapping("/updateDepartment")
	public ResponseEntity<Object> updateDepartment(@RequestBody TblDepartmentMgmtDto tblDepartmentMgmtDto, Authentication authentication){
		ResponseEntity<Object> validity = departmentUserMgmtCoreSvc.validatorUpdate(tblDepartmentMgmtDto);
		if(validity!=null) {
			return validity;
		}
        
		tblDepartmentMgmtDto = departmentUserMgmtCoreSvc.updateDepartment(tblDepartmentMgmtDto, authentication.getName());
		return new ResponseEntity<Object>(successResponseCheck(tblDepartmentMgmtDto, "Department Berhasil Diupdate", 44), HttpStatus.OK);
		
	}
	
}
