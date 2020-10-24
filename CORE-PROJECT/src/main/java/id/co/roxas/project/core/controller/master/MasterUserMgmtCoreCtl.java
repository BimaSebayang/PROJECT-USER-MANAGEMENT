package id.co.roxas.project.core.controller.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.roxas.common.lib.dto.user_mgmt.master.TblMasterMgmtDto;
import id.co.roxas.project.core.controller.BaseCtl;
import id.co.roxas.project.core.service.master.MasterUserMgmtCoreSvc;

@RestController
@RequestMapping("/masterUserMgmt")
public class MasterUserMgmtCoreCtl extends BaseCtl{

	@Autowired
	private MasterUserMgmtCoreSvc masterUserMgmtCoreSvc;
	   
	@PostMapping("/add")
	public ResponseEntity<Object> addUserMasterMgmt(@RequestBody TblMasterMgmtDto masterMgmtDto,Authentication authentication){
		ResponseEntity<Object> responseValidity = masterUserMgmtCoreSvc.validityMasterUserMgmtSave(masterMgmtDto.getMasterDescription(),
				masterMgmtDto.getMasterGroup());
		if(responseValidity!=null) {
			return responseValidity;
		}
		
		TblMasterMgmtDto body = masterUserMgmtCoreSvc.createTblMasterMgmt
								(masterMgmtDto.getMasterDescription(), masterMgmtDto.getMasterGroup());
		return new ResponseEntity<Object>(successResponseCheck(body, "Data Berhasil Disimpan", SUCCESS_3), HttpStatus.OK);
	} 
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateUserMasterMgmt(@RequestBody TblMasterMgmtDto masterMgmtDto,Authentication authentication){
		ResponseEntity<Object> responseValidity = masterUserMgmtCoreSvc.validityMasterUserMgmtUpdate(masterMgmtDto);
		if(responseValidity!=null) {
			return responseValidity;
		}
		
		TblMasterMgmtDto body = masterUserMgmtCoreSvc.updateTblMasterMgmt(masterMgmtDto);
		return new ResponseEntity<Object>(successResponseCheck(body, "Data Berhasil Disimpan", SUCCESS_6), HttpStatus.OK);
	} 
	
}
