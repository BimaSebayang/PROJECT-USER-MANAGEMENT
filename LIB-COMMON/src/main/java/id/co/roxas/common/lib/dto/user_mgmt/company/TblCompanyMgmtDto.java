package id.co.roxas.common.lib.dto.user_mgmt.company;

import java.util.Date;

public class TblCompanyMgmtDto {

	private Long userCompanyId; 
	private String companyCode;
	private String companyName;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	public Long getUserCompanyId() {
		return userCompanyId;
	}
	public void setUserCompanyId(Long userCompanyId) {
		this.userCompanyId = userCompanyId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	

}
