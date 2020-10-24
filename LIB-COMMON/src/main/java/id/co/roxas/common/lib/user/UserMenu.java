package id.co.roxas.common.lib.user;

public class UserMenu {
private String menuCode;
	
	private String menuName;
	
	private String urlMenu;
	
	private Long subMenuNumber;  //--> Put Zero Is Non Sub Menu
	
	private Long subMenuFrom; //--> Put Null if Non Sub Menu

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
	
	
}
