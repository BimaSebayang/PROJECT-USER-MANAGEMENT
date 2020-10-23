package id.co.roxas.common.lib.dto.user_mgmt.user;

import java.util.Date;

public class TblUserMgmtDto {

	private String userId;

	private String password;

	private Integer errorPassword;

	private Boolean isAccountActive;

	private Boolean isPasswordExpired;

	private Date createdDate;
	private String createdBy;

	private Date updatedDate;
	private String updatedBy;
	private Long userDetailId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getErrorPassword() {
		return errorPassword;
	}

	public void setErrorPassword(Integer errorPassword) {
		this.errorPassword = errorPassword;
	}

	public Boolean getIsAccountActive() {
		return isAccountActive;
	}

	public void setIsAccountActive(Boolean isAccountActive) {
		this.isAccountActive = isAccountActive;
	}

	public Boolean getIsPasswordExpired() {
		return isPasswordExpired;
	}

	public void setIsPasswordExpired(Boolean isPasswordExpired) {
		this.isPasswordExpired = isPasswordExpired;
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

	public Long getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(Long userDetailId) {
		this.userDetailId = userDetailId;
	}

}
