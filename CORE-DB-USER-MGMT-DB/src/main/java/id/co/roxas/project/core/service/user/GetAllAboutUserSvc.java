package id.co.roxas.project.core.service.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.roxas.common.lib.dto.user_mgmt.custom.TblUserDtlMgmtAll;
import id.co.roxas.common.lib.dto.user_mgmt.master.TblMasterMgmtDto;
import id.co.roxas.common.lib.dto.user_mgmt.user.TblUserMgmtDtlDto;
import id.co.roxas.common.lib.dto.user_mgmt.user.TblUserMgmtDto;
import id.co.roxas.project.core.dao.user.TblUserMgmtDao;
import id.co.roxas.project.core.repository.master.TblMasterMgmt;
import id.co.roxas.project.core.repository.user.TblUserMgmt;
import id.co.roxas.project.core.repository.user.TblUserMgmtDtl;
import id.co.roxas.project.core.service.BaseSvc;

@Service("getAllAboutUserSvc")
@Transactional
public class GetAllAboutUserSvc extends BaseSvc{

	@Autowired
	private TblUserMgmtDao tblUserMgmtDao;
	
	public void updateWrongPassword(String userId){
		tblUserMgmtDao.updateErrorPassword(userId);
	}
	
	public TblUserDtlMgmtAll getAllInformationOfAUser(String userId) {
		TblUserDtlMgmtAll tblUserDtlMgmtAll = new TblUserDtlMgmtAll();
		
		TblUserMgmtDto tblUserMgmtDto = new TblUserMgmtDto();
		TblUserMgmtDtlDto tblUserMgmtDtlDto = new TblUserMgmtDtlDto();
		TblMasterMgmtDto tblMasterMgmtDto = new TblMasterMgmtDto();
		
//		TblUserMgmt tblUserMgmt = new TblUserMgmt();
//		TblUserMgmtDtl tblUserMgmtDtl = new TblUserMgmtDtl();
//		TblMasterMgmt tblMasterMgmt = new TblMasterMgmt();
		
		List<Object[]> obj = tblUserMgmtDao.getUserAllDetail(userId);
		
		if(obj!=null&&obj.size()==1) {
			tblUserMgmtDto = mapperFacade.map((TblUserMgmt)obj.get(0)[0], TblUserMgmtDto.class);
			tblUserMgmtDtlDto = mapperFacade.map((TblUserMgmtDtl)obj.get(0)[1], TblUserMgmtDtlDto.class);
			tblMasterMgmtDto = mapperFacade.map((TblMasterMgmt)obj.get(0)[2], TblMasterMgmtDto.class);
		}
		
		tblUserDtlMgmtAll.setTblMasterMgmtDto(tblMasterMgmtDto);
		tblUserDtlMgmtAll.setTblUserMgmtDtlDto(tblUserMgmtDtlDto);
		tblUserDtlMgmtAll.setTblUserMgmtDto(tblUserMgmtDto);
		
		return tblUserDtlMgmtAll;
	}
	
	
}
