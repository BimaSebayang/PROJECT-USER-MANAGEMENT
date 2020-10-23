package id.co.roxas.project.core.repository.menu;

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
@Table(name="TblMenuMgmtDtl")
public class TblMenuMgmtDtl {

	@Id
	@Column(name="userMenuId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userMenuId; 
	
	@Column(name="menuCode", nullable = false, unique = true)
	private String menuCode;
	
	@Column(name="menuType", nullable = false)
	private Long menuType;   //---> Diambil dari table master yang sama dengan userType pada user mgmt
	
	@Column(name="menuDepartmentId", nullable = false)
	private Long menuDepartmentId;  //---> Diambil dari table TblDepartementMgmt
	
	@Column(name="isUpdatable", nullable = false)
	private Boolean isUpdatable;
	
	@Column(name="isActive", nullable = false)
	private Boolean isActive;
	
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
