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
@Table(name="TblMenuMgmt")
public class TblMenuMgmt {
	
	
	@Id
	@Column(name="userMenuId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userMenuId; 
	
	@Column(name="menuCode", nullable = false, unique = true)
	private String menuCode;
	
	@Column(name="menuName", nullable = false)
	private String menuName;
	
	@Column(name="urlMenu")
	private String urlMenu;
	
	@Column(name="componentMenu", nullable = false)
	private String componentMenu;
	
	@Column(name="isMenuPrivate", nullable = false)
	private Boolean isMenuPrivate;
	
	@Column(name="isUpdatable", nullable = false)
	private Boolean isUpdatable;
	
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
	
	@Column(name="subMenuNumber", nullable = false)
	private Long subMenuNumber;  //--> Put Zero Is Non Sub Menu
	
	@Column(name="subMenuFrom")
	private Long subMenuFrom; //--> Put Null if Non Sub Menu
	
	@Column(name="isMenuActive", nullable = false)
	private Boolean isMenuActive; //--> Put Null if Non Sub Menu
	
	@Column(name="menuIcon", nullable = true)
	private String menuIcon;
	
	
	
	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Boolean getIsMenuActive() {
		return isMenuActive;
	}

	public void setIsMenuActive(Boolean isMenuActive) {
		this.isMenuActive = isMenuActive;
	}

	public Long getSubMenuNumber() {
		return subMenuNumber;
	}

	public void setSubMenuNumber(Long subMenuNumber) {
		this.subMenuNumber = subMenuNumber;
	}

	public Long getSubMenuFrom() {
		return subMenuFrom;
	}

	public void setSubMenuFrom(Long subMenuFrom) {
		this.subMenuFrom = subMenuFrom;
	}

	public String getUrlMenu() {
		return urlMenu;
	}

	public void setUrlMenu(String urlMenu) {
		this.urlMenu = urlMenu;
	}

	public String getComponentMenu() {
		return componentMenu;
	}

	public void setComponentMenu(String componentMenu) {
		this.componentMenu = componentMenu;
	}

	public Boolean getIsMenuPrivate() {
		return isMenuPrivate;
	}

	public void setIsMenuPrivate(Boolean isMenuPrivate) {
		this.isMenuPrivate = isMenuPrivate;
	}

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

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Boolean getIsUpdatable() {
		return isUpdatable;
	}

	public void setIsUpdatable(Boolean isUpdatable) {
		this.isUpdatable = isUpdatable;
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
