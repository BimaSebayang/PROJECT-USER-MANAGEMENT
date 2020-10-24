package id.co.roxas.project.core.service.menu;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

@Service("menuManagementDtlCreatorSvc")
@Transactional
public class MenuManagementDtlCreatorSvc extends BaseSvc{

	@Autowired
	private TblMenuMgmtDtlDao tblMenuMgmtDtlDao;
	
	@Autowired
	private TblMasterMgmtDao tblMasterMgmtDao;
	
	@Autowired
	private TblMenuMgmtDao tblMenuMgmtDao;
	
	@Autowired
	private TblDepartmentMgmtDao tblDepartmentMgmtDao;
	
	public ResponseEntity<Object> saveMenuMgmtDtl(TblMenuMgmtDtlDto tblMenuMgmtDtlDto, String userId){
		if(tblMasterMgmtDao.getTblMasterMgmtById(tblMenuMgmtDtlDto.getMenuType())==null) {
			return new ResponseEntity<Object>(validationWordingCheck("menu type not found in master", 
					"Tipe User : " + tblMenuMgmtDtlDto.getMenuType() + " tidak ditemukan di list master tipe user", 34), HttpStatus.NOT_FOUND);
		}
		else if(tblMenuMgmtDao.getMenuMgmtByMenuCode(tblMenuMgmtDtlDto.getMenuCode())==null) {
			return new ResponseEntity<Object>(validationWordingCheck("menu code not found in table tblMenuMgmt", 
					"Kode Menu: " + tblMenuMgmtDtlDto.getMenuCode() + " "
					+ " tidak ditemukan di list kode menu yang ada", 35), HttpStatus.NOT_FOUND);
		}
		else if(tblDepartmentMgmtDao.getDepartementMgmtByItsId(tblMenuMgmtDtlDto.getMenuDepartmentId())==null) {
			return new ResponseEntity<Object>(validationWordingCheck("department id not found in table TblDepartmentMgmt", 
					"Id Departement : " + tblMenuMgmtDtlDto.getMenuDepartmentId() + " "
					+ " tidak ditemukan di list Departement Yang Ada", 36), HttpStatus.NOT_FOUND);
		}
		else if(tblMenuMgmtDtlDao.getTblMenuByMenuCodeMenuTypeMenuDepartmentId
				(tblMenuMgmtDtlDto.getMenuCode(), tblMenuMgmtDtlDto.getMenuType(),
						tblMenuMgmtDtlDto.getMenuDepartmentId())!=null) {
			return new ResponseEntity<Object>(validationWordingCheck("Already Authorized", 
					"Menu telah diotorisasikan ke departement dan user bersangkutan", 36), HttpStatus.NOT_FOUND);
		}
		
		
		TblMenuMgmtDtl tblMenuMgmtDtl = new TblMenuMgmtDtl();
		tblMenuMgmtDtl = mapperFacade.map(tblMenuMgmtDtlDto, TblMenuMgmtDtl.class);
		tblMenuMgmtDtl.setIsActive(false);
		tblMenuMgmtDtl.setCreatedBy(userId);
		tblMenuMgmtDtl.setCreatedDate(new Date());
		
		tblMenuMgmtDtlDao.save(tblMenuMgmtDtl);
		tblMenuMgmtDtlDto = mapperFacade.map(tblMenuMgmtDtl, TblMenuMgmtDtlDto.class);
		return new ResponseEntity<Object>(successResponseCheck(tblMenuMgmtDtlDto, "Menu Berhasil di Otorisasikan", 32), HttpStatus.OK);
	}
	
}
