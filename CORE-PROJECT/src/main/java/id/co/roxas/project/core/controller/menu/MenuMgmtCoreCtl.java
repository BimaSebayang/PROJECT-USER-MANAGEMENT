package id.co.roxas.project.core.controller.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import id.co.roxas.common.lib.dto.user_mgmt.menu.TblMenuMgmtDto;
import id.co.roxas.project.core.controller.BaseCtl;
import id.co.roxas.project.core.service.menu.MenuManagementCreatorSvc;

@RestController
@RequestMapping("/menuMgmtCoreCtl")
public class MenuMgmtCoreCtl extends BaseCtl {

	@Autowired
	private MenuManagementCreatorSvc menuManagementCreatorSvc;
	
	@GetMapping("/pagingListMenu")
	public ResponseEntity<Object> pagingListDepartment(
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "size", required = true) Integer size,
			@RequestParam(value = "sort", required = true) List<String> sorts
			){
		System.err.println("page : " + new Gson().toJson(pageableSetting(page, size, sorts)));
		
		return new ResponseEntity<Object>(menuManagementCreatorSvc.getPage(pageableSetting(page, size, sorts)), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveMenuMgmtCoreCtl(@RequestBody TblMenuMgmtDto tblMenuMgmtDto, 
							Authentication authentication){
		ResponseEntity<Object> response = menuManagementCreatorSvc.validityMenuMgmtSave(tblMenuMgmtDto);
		if(response!=null) {
			return response;
		}
				
		String menuCode = menuManagementCreatorSvc.generateMenuCode();
		tblMenuMgmtDto.setMenuCode(menuCode);

		TblMenuMgmtDto menuMgmtDto = menuManagementCreatorSvc.saveMenuMgmt(tblMenuMgmtDto, authentication.getName());
		return new ResponseEntity<Object>(successResponseCheck(menuMgmtDto, "Menu berhasil disimpan", SUCCESS_7), HttpStatus.OK);
	}
	
	@PutMapping("/updateMenuStatus/{statusCode}")
	public ResponseEntity<Object> saveMenuMgmtCoreCtl(
			@RequestParam(value = "menuCode", required = true) String menuCode,
			@PathVariable("statusCode")String statusCode,
			Authentication authentication){
		Boolean code = null; 
	    if(statusCode.equals("activate")) {
	    	code = true;
	    }   	
	    else if(statusCode.equals("deactivate")) {
	    	code = false;
	    }
	    else {
	    	return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
	    }
	    
		return menuManagementCreatorSvc.updateStatusMenu(menuCode, code, authentication.getName());
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateMenuMgmtCoreCtl(@RequestBody TblMenuMgmtDto tblMenuMgmtDto, 
							Authentication authentication){
		ResponseEntity<Object> response = menuManagementCreatorSvc.validityMenuMgmtUpdate(tblMenuMgmtDto);
		if(response!=null) {
			return response;
		}
				
		TblMenuMgmtDto menuMgmtDto = menuManagementCreatorSvc.updateMenuMgmt(tblMenuMgmtDto, authentication.getName());
		return new ResponseEntity<Object>(successResponseCheck(menuMgmtDto, "Menu berhasil disimpan", SUCCESS_7), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteMenu/{menuCode}")
	public ResponseEntity<Object> saveMenuMgmtCoreCtl(
			@PathVariable("menuCode")String menuCode,
			Authentication authentication){
		return new ResponseEntity<Object>(menuManagementCreatorSvc.deleteMenuByMenuCode(menuCode), HttpStatus.OK);
	}
	
	@GetMapping("/searchAllMenuById")
	public ResponseEntity<Object> searchAllMenuById(
			@RequestParam(value = "menuId", required = true) Long menuId
			){
		return menuManagementCreatorSvc.searchMenuById(menuId);
	}
	
	@GetMapping("/searchAllMenuByCode")
	public ResponseEntity<Object> searchAllMenuByCode(
			@RequestParam(value = "menuCode", required = true) String menuCode
			){
		return menuManagementCreatorSvc.searchMenuByCode(menuCode);
	}
	
	@GetMapping("/searchAllMenu/ByMenuCodeOrMenuId")
	public ResponseEntity<Object> searchAllMenuById(
			@RequestParam(value = "query", required = true) String query
			){
		List<TblMenuMgmtDto> tblMenuMgmtDtos = menuManagementCreatorSvc.getAllMenuByLikeMenuCodeOrMenuName(query);
		if(tblMenuMgmtDtos==null||tblMenuMgmtDtos.size()==0) {
			return new ResponseEntity<Object>(validationWordingCheck("query not found", "Data Tidak Ditemukan", 22), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(successResponseCheck(tblMenuMgmtDtos, 
				"Data Ditemukan", 24), HttpStatus.OK);
	}
	
}
