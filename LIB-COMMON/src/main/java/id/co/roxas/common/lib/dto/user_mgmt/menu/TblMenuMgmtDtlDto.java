package id.co.roxas.common.lib.dto.user_mgmt.menu;

import java.util.Date;

public class TblMenuMgmtDtlDto {

	private Long userMenuId; 
	
	private String menuCode;
	
	private Long menuType;   //---> Diambil dari table master yang sama dengan userType pada user mgmt
	
	private Long menuDepartmentId;  //---> Diambil dari table TblDepartementMgmt
	
	private Boolean isUpdatable;
	
	private Boolean isActive;
	
	private Date createdDate;
	
	private String createdBy;
	
	private Date updatedDate;
	
	private String updatedBy;
	

	public Long getUserMenuId() {
		return userMenuId;
	}

	public void setUserMenuId(Long userMenuId) {
		this.userMenuId = userMenuId;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public Long getMenuType() {
		return menuType;
	}

	public void setMenuType(Long menuType) {
		this.menuType = menuType;
	}

	public Long getMenuDepartmentId() {
		return menuDepartmentId;
	}

	public void setMenuDepartmentId(Long menuDepartmentId) {
		this.menuDepartmentId = menuDepartmentId;
	}

	public Boolean getIsUpdatable() {
		return isUpdatable;
	}

	public void setIsUpdatable(Boolean isUpdatable) {
		this.isUpdatable = isUpdatable;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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
