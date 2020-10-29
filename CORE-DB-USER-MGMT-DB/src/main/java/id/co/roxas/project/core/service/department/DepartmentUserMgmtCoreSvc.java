package id.co.roxas.project.core.service.department;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.co.roxas.common.lib.dto.user_mgmt.department.TblDepartmentMgmtDto;
import id.co.roxas.common.lib.helper.PagingMeClz;
import id.co.roxas.project.core.dao.department.TblDepartmentMgmtDao;
import id.co.roxas.project.core.lib.PagingRepositoryToDto;
import id.co.roxas.project.core.lib.interfaces.PagingJson;
import id.co.roxas.project.core.repository.department.TblDepartmentMgmt;
import id.co.roxas.project.core.repository.menu.TblMenuMgmt;
import id.co.roxas.project.core.service.BaseSvc;

@Service("departmentUserMgmtCoreSvc")
@Transactional
public class DepartmentUserMgmtCoreSvc extends BaseSvc{

	
	@Autowired
	private TblDepartmentMgmtDao tblDepartmentMgmtDao;
	
	public TblDepartmentMgmtDto saveDepartment(TblDepartmentMgmtDto departmentMgmtDto, String userSid) {
		TblDepartmentMgmt tblDepartmentMgmt = new TblDepartmentMgmt();
		tblDepartmentMgmt = mapperFacade.map(departmentMgmtDto, TblDepartmentMgmt.class);
		tblDepartmentMgmt.setCreatedBy(userSid);
		tblDepartmentMgmt.setCreatedDate(new Date());
		tblDepartmentMgmt.setDepartmentCode(generateCode());
		tblDepartmentMgmtDao.save(tblDepartmentMgmt);
		departmentMgmtDto = mapperFacade.map(tblDepartmentMgmt, TblDepartmentMgmtDto.class);
		return departmentMgmtDto;
	}
	
	public TblDepartmentMgmtDto updateDepartment(TblDepartmentMgmtDto departmentMgmtDto, String userSid) {
		TblDepartmentMgmt tblDepartmentMgmt = tblDepartmentMgmtDao.
											  getDepartmentMgmtByItsCode(departmentMgmtDto.getDepartmentCode());
		tblDepartmentMgmt.setDepartmentName(departmentMgmtDto.getDepartmentName());
		tblDepartmentMgmt.setUpdatedBy(userSid);
		tblDepartmentMgmt.setUpdatedDate(new Date());
		tblDepartmentMgmtDao.save(tblDepartmentMgmt);
		departmentMgmtDto = mapperFacade.map(tblDepartmentMgmt, TblDepartmentMgmtDto.class);
		return departmentMgmtDto;
	}
	
	public ResponseEntity<Object> validatorSave(TblDepartmentMgmtDto tblDepartmentMgmtDto){
	   TblDepartmentMgmt name = tblDepartmentMgmtDao.getDepartmentMgmtByItsName(tblDepartmentMgmtDto.getDepartmentName());	
	   if(name!=null) {
		   return new ResponseEntity<Object>(validationWordingCheck
				   ("not null value of department", "Nama Department Sudah Ada", 33), HttpStatus.CONFLICT);
	   }
	   else {
		   return null;
	   }
	}
	
	public ResponseEntity<Object> validatorUpdate(TblDepartmentMgmtDto tblDepartmentMgmtDto){
		 TblDepartmentMgmt name = tblDepartmentMgmtDao.getDepartmentMgmtByItsName(tblDepartmentMgmtDto.getDepartmentName());	
		 TblDepartmentMgmt code = tblDepartmentMgmtDao.getDepartmentMgmtByItsCode(tblDepartmentMgmtDto.getDepartmentCode());
		 if(name!=null) {
			   return new ResponseEntity<Object>(validationWordingCheck
					   ("not null value of department", "Nama Department Sudah Ada", 33), HttpStatus.CONFLICT);
		   }
		 else if(code==null) {
			 return new ResponseEntity<Object>(validationWordingCheck
					   ("not null value of department", "Code Department Tidak ditemukan", 34), HttpStatus.NOT_FOUND);
		   
		 }
		 else {
			 return null;
		 }
		   
	}
	
	public String generateCode() {
		String codeMenu = getSaltString(4);
		TblDepartmentMgmt tblDepartmentMgmt = new TblDepartmentMgmt();
		do {
			codeMenu = getSaltString(4);
			tblDepartmentMgmt = tblDepartmentMgmtDao.getDepartmentMgmtByItsCode(codeMenu);
		}
		while(tblDepartmentMgmt!=null);
		
		return codeMenu;
	}
	
	public PagingMeClz<TblDepartmentMgmtDto> getPageListDepartmen(Pageable pageable){
		Page<TblDepartmentMgmt> page = tblDepartmentMgmtDao.getDepartmentMgmPaging(pageable);
		PagingJson<TblDepartmentMgmt, TblDepartmentMgmtDto> pagingJson = new PagingRepositoryToDto<TblDepartmentMgmt, TblDepartmentMgmtDto>();
		pagingJson.mapperRepositoryToDto(page, TblDepartmentMgmtDto.class);
		return pagingJson.printDtoInPaging();
	} 
	
}
