package id.co.roxas.project.core.controller.master;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Strings;

import id.co.roxas.common.lib.dto.user_mgmt.menu.TblMenuMgmtDtlDto;
import id.co.roxas.common.lib.dto.user_mgmt.menu.TblMenuMgmtDto;
import id.co.roxas.project.core.dao.department.TblDepartmentMgmtDao;
import id.co.roxas.project.core.dao.master.TblMasterMgmtDao;
import id.co.roxas.project.core.dao.user_menu.TblMenuMgmtDao;
import id.co.roxas.project.core.dao.user_menu.TblMenuMgmtDtlDao;
import id.co.roxas.project.core.repository.menu.TblMenuMgmt;
import id.co.roxas.project.core.repository.menu.TblMenuMgmtDtl;
import id.co.roxas.project.core.service.BaseSvc;
import id.co.roxas.project.core.service.menu.MenuManagementDtlCreatorSvc;

@RestController
@RequestMapping("/menuManagementDtlCreatorCtl")
public class MenuManagementDtlCreatorCtl extends BaseSvc{

	@Autowired
	private MenuManagementDtlCreatorSvc menuManagementDtlCreatorSvc;
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveMenuDetailManagement(@RequestBody TblMenuMgmtDtlDto tblMenuMgmtDtlDto
			, Authentication authentication){
		
		return menuManagementDtlCreatorSvc.saveMenuMgmtDtl(tblMenuMgmtDtlDto, authentication.getName());
	}
	
}
