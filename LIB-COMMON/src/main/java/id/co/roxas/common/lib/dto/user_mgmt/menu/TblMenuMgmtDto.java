package id.co.roxas.common.lib.dto.user_mgmt.menu;

import java.util.Date;


public class TblMenuMgmtDto {

	
	private Long userMenuId; 
	
	private String menuCode;
	
	private String menuName;
	
	private String urlMenu;
	
	private String componentMenu;
	
	private Boolean isMenuPrivate;
	
	private Boolean isUpdatable;
	
	private Date createdDate;
	
	private String createdBy;
	
	private Date updatedDate;
	
	private String updatedBy;
	
	private Long subMenuNumber;  //--> Put Zero Is Non Sub Menu
	
	private Long subMenuFrom; //--> Put Null if Non Sub Menu
	
	private Boolean isMenuActive;
	
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
