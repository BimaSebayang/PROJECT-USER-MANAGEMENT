package id.co.roxas.common.lib.dto.user_mgmt.custom;

import id.co.roxas.common.lib.dto.user_mgmt.master.TblMasterMgmtDto;
import id.co.roxas.common.lib.dto.user_mgmt.user.TblUserMgmtDtlDto;
import id.co.roxas.common.lib.dto.user_mgmt.user.TblUserMgmtDto;

public class TblUserDtlMgmtAll {

	private TblUserMgmtDto tblUserMgmtDto;
	private TblUserMgmtDtlDto tblUserMgmtDtlDto;
	private TblMasterMgmtDto tblMasterMgmtDto;
	
	public TblUserMgmtDto getTblUserMgmtDto() {
		return tblUserMgmtDto;
	}
	public void setTblUserMgmtDto(TblUserMgmtDto tblUserMgmtDto) {
		this.tblUserMgmtDto = tblUserMgmtDto;
	}
	public TblUserMgmtDtlDto getTblUserMgmtDtlDto() {
		return tblUserMgmtDtlDto;
	}
	public void setTblUserMgmtDtlDto(TblUserMgmtDtlDto tblUserMgmtDtlDto) {
		this.tblUserMgmtDtlDto = tblUserMgmtDtlDto;
	}
	public TblMasterMgmtDto getTblMasterMgmtDto() {
		return tblMasterMgmtDto;
	}
	public void setTblMasterMgmtDto(TblMasterMgmtDto tblMasterMgmtDto) {
		this.tblMasterMgmtDto = tblMasterMgmtDto;
	}
	
	
}
