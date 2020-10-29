package id.co.roxas.project.core.controller.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import id.co.roxas.common.lib.dto.user_mgmt.custom.TblUserDtlMgmtAll;
import id.co.roxas.common.lib.dto.user_mgmt.menu.TblMenuMgmtDto;
import id.co.roxas.common.lib.helper.DigraphSet;
import id.co.roxas.common.lib.helper.Edge;
import id.co.roxas.common.lib.user.UserHeader;
import id.co.roxas.project.core.controller.BaseCtl;
import id.co.roxas.project.core.service.menu.MenuManagementCreatorSvc;
import id.co.roxas.project.core.service.user.GetAllAboutUserSvc;

@RestController
@RequestMapping("/auth")
public class AuthenticationCtl extends BaseCtl{

	@Autowired
	private GetAllAboutUserSvc getAllAboutUserSvc;
	
	@Autowired
	private MenuManagementCreatorSvc menuManagementCreatorSvc;
	
	@GetMapping("/checkAuth")
	public ResponseEntity<Boolean> checkAuth(Authentication authentication) {
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@GetMapping("/getAllMenu/ByMyAuth")
	public ResponseEntity<List<TblMenuMgmtDto>> getAllMenuByMyAuth(Authentication authentication){
		TblUserDtlMgmtAll tblUserDtlMgmtAll = getAllAboutUserSvc.getAllInformationOfAUser(authentication.getName());
		List<TblMenuMgmtDto> tblMenuMgmtDtos = menuManagementCreatorSvc.getAllAccesableMenuByItsMenuDepartmentIdAndUserType
				(tblUserDtlMgmtAll.getTblMasterMgmtDto().getMasterId(), tblUserDtlMgmtAll.getTblDepartmentMgmtDto().getUserDepartmentId());
		
		return new ResponseEntity<List<TblMenuMgmtDto>>(tblMenuMgmtDtos,HttpStatus.OK);
	}
	
}
