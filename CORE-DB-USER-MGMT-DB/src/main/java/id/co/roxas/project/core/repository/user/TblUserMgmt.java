package id.co.roxas.project.core.repository.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TblUserMgmt")
public class TblUserMgmt {

	@Id
	@Column(length = 30, name = "userId")
	private String userId;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "errorPassword", nullable = false)
	private Integer errorPassword;
	
	@Column(name = "isAccountActive", nullable = false)
	private Boolean isAccountActive;
	
	@Column(name="isPasswordExpired", nullable = false)
	private Boolean isPasswordExpired;
	
	@Column(name="createdDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name="createdBy", nullable = false)
	private String createdBy;
	
	@Column(name="updatedDate", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	
	@Column(name="updatedBy", nullable = true)
	private String updatedBy;
	
	@Column(name="userDetailId", nullable = false)
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
