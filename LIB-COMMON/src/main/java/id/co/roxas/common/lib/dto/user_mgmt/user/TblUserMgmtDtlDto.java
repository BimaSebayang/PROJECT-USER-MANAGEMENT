package id.co.roxas.common.lib.dto.user_mgmt.user;

import java.util.Date;

public class TblUserMgmtDtlDto {
	
	
	private Long userDetailId;
	
	private String userName;

	private String userEmail;
	
	private Long userCompanyId;
	
	private Long userDepartmentId;
	
	private Long userType;   //---> Diambil dari table master 
	
	private Date createdDate;
	
	private String createdBy;
	
	private Date updatedDate;
	
	private String updatedBy;

	public Long getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(Long userDetailId) {
		this.userDetailId = userDetailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getUserCompanyId() {
		return userCompanyId;
	}

	public void setUserCompanyId(Long userCompanyId) {
		this.userCompanyId = userCompanyId;
	}

	public Long getUserDepartmentId() {
		return userDepartmentId;
	}

	public void setUserDepartmentId(Long userDepartmentId) {
		this.userDepartmentId = userDepartmentId;
	}

	public Long getUserType() {
		return userType;
	}

	public void setUserType(Long userType) {
		this.userType = userType;
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
