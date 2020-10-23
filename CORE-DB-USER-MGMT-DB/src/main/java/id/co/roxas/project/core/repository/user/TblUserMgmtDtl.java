package id.co.roxas.project.core.repository.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TblUserMgmtDtl")
public class TblUserMgmtDtl {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userDetailId", nullable = false)
	private Long userDetailId;
	
	@Column(name="userName", nullable = false)
	private String userName;
	
	@Column(name="userEmail", nullable = true)
	private String userEmail;
	
	@Column(name="userCompanyId", nullable = false)
	private Long userCompanyId;
	
	@Column(name="userDepartmentId", nullable = false)
	private Long userDepartmentId;
	
	@Column(name="userType", nullable = false)
	private Long userType;   //---> Diambil dari table master 
	
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
	
}
