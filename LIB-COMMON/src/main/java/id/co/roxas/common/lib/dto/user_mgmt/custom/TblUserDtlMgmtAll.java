package id.co.roxas.common.lib.dto.user_mgmt.custom;

import id.co.roxas.common.lib.dto.user_mgmt.company.TblCompanyMgmtDto;
import id.co.roxas.common.lib.dto.user_mgmt.department.TblDepartmentMgmtDto;
import id.co.roxas.common.lib.dto.user_mgmt.master.TblMasterMgmtDto;
import id.co.roxas.common.lib.dto.user_mgmt.user.TblUserMgmtDtlDto;
import id.co.roxas.common.lib.dto.user_mgmt.user.TblUserMgmtDto;

public class TblUserDtlMgmtAll {

	private TblUserMgmtDto tblUserMgmtDto;
	private TblUserMgmtDtlDto tblUserMgmtDtlDto;
	private TblMasterMgmtDto tblMasterMgmtDto;
	private TblDepartmentMgmtDto tblDepartmentMgmtDto;
	private TblCompanyMgmtDto tblCompanyMgmtDto;
	
	
	
	public TblDepartmentMgmtDto getTblDepartmentMgmtDto() {
		return tblDepartmentMgmtDto;
	}
	public void setTblDepartmentMgmtDto(TblDepartmentMgmtDto tblDepartmentMgmtDto) {
		this.tblDepartmentMgmtDto = tblDepartmentMgmtDto;
	}
	public TblCompanyMgmtDto getTblCompanyMgmtDto() {
		return tblCompanyMgmtDto;
	}
	public void setTblCompanyMgmtDto(TblCompanyMgmtDto tblCompanyMgmtDto) {
		this.tblCompanyMgmtDto = tblCompanyMgmtDto;
	}
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
