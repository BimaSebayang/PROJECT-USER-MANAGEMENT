package id.co.roxas.project.core.service.master;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.co.roxas.common.lib.dto.user_mgmt.master.TblMasterMgmtDto;
import id.co.roxas.project.core.dao.master.TblMasterMgmtDao;
import id.co.roxas.project.core.repository.master.TblMasterMgmt;
import id.co.roxas.project.core.service.BaseSvc;

@Service("masterUserMgmtCoreSvc")
@Transactional
public class MasterUserMgmtCoreSvc extends BaseSvc{

	@Autowired
	private TblMasterMgmtDao tblMasterMgmtDao;
	
	public ResponseEntity<Object> validityMasterUserMgmtSave(String masterDescription, String masterGroup){
		if(isThereisWhiteSpace(masterGroup)) {
			return new ResponseEntity<Object>(validationWordingCheck
					("There is whitespace", "Master group tidak boleh menggunakan spasi", ERROR_1), HttpStatus.BAD_REQUEST);
		}
		else if(tblMasterMgmtDao.getTblMasterMgmtByMasterGroupAndMasterDescption
				(masterDescription, masterGroup)!=null){
			return new ResponseEntity<Object>(validationWordingCheck
					("Existing Data", "Master Description : " + masterDescription + " Sudah ada di master group : " + masterGroup, ERROR_2), 
					HttpStatus.CONFLICT);
		}
		else {
		return null;
		}
	}
	
	public TblMasterMgmtDto createTblMasterMgmt(String masterDescription, String masterGroup) {
		TblMasterMgmtDto resultSave = new TblMasterMgmtDto();
		TblMasterMgmt saveMasterDescription = new TblMasterMgmt();
		saveMasterDescription.setMasterDescription(masterDescription);
		saveMasterDescription.setMasterGroup(masterGroup);
		tblMasterMgmtDao.save(saveMasterDescription);
		
		if(tblMasterMgmtDao.getTblMasterMgmtByMasterGroupForCluster(masterGroup)==null) {
		TblMasterMgmt addNewMasterDescriptionForMasterGroup = new TblMasterMgmt(); //---> Bagian untuk mengadd otomatis ke master group.
		addNewMasterDescriptionForMasterGroup.setMasterDescription(masterGroup);
		addNewMasterDescriptionForMasterGroup.setMasterGroup(MASTER_GROUP_CLUSTER);
		tblMasterMgmtDao.save(addNewMasterDescriptionForMasterGroup);
		}
		resultSave = mapperFacade.map(saveMasterDescription, TblMasterMgmtDto.class);
		return resultSave;
	}
	
	public TblMasterMgmtDto updateTblMasterMgmt(TblMasterMgmtDto masterMgmtDto) {
		TblMasterMgmt masterMgmt = tblMasterMgmtDao.getOne(masterMgmtDto.getMasterId());
		masterMgmt.setMasterDescription(masterMgmtDto.getMasterDescription());
		tblMasterMgmtDao.save(masterMgmt);
		
		TblMasterMgmtDto mgmtDto = mapperFacade.map(masterMgmt, TblMasterMgmtDto.class);
		return mgmtDto;
	}
	
	public ResponseEntity<Object> validityMasterUserMgmtUpdate(TblMasterMgmtDto masterMgmtDto){
		TblMasterMgmt masterMgmt = tblMasterMgmtDao.getTblMasterMgmtById(masterMgmtDto.getMasterId());
		if(masterMgmt==null) {
			return new ResponseEntity<Object>(validationWordingCheck
					("Id Not Found", "Master description Tidak Dapat Diubah. Dikarenakan, "
							+ "master description tidak ditemukan.", ERROR_4), HttpStatus.NOT_FOUND);
		}
		else if(masterMgmtDto.getMasterDescription().equals(masterMgmt.getMasterDescription())) {
			return new ResponseEntity<Object>(validationWordingCheck
					("Not Dirty Form", "Master Group Tidak Ada Perubahan", ERROR_5), HttpStatus.NOT_ACCEPTABLE);
		}
		else {
		return null;
		}
	}
	
}
