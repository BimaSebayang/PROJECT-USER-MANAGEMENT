package id.co.roxas.common.lib.dto.user_mgmt.department;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import id.co.roxas.common.lib.share.MasterComponent;


import java.util.TimeZone;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
public class TblDepartmentMgmtDto {

	
    private Long userDepartmentId; 
	private String departmentCode;
	private String departmentName;
	@JsonFormat(pattern = MasterComponent.FORMAT_DATE_V1,timezone = MasterComponent.TIMEZONE_V1)
	private Date createdDate;
	private String createdBy;
	@JsonFormat(pattern = MasterComponent.FORMAT_DATE_V1,timezone = MasterComponent.TIMEZONE_V1)
	private Date updatedDate;
	private String updatedBy;
	private Boolean isUpdatable;
	private Boolean isDeletable;
	
	
	
	public Boolean getIsUpdatable() {
		return isUpdatable;
	}
	public void setIsUpdatable(Boolean isUpdatable) {
		this.isUpdatable = isUpdatable;
	}
	public Boolean getIsDeletable() {
		return isDeletable;
	}
	public void setIsDeletable(Boolean isDeletable) {
		this.isDeletable = isDeletable;
	}
	public Long getUserDepartmentId() {
		return userDepartmentId;
	}
	public void setUserDepartmentId(Long userDepartmentId) {
		this.userDepartmentId = userDepartmentId;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
