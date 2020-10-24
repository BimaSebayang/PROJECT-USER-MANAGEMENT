package id.co.roxas.common.lib.user;

import java.util.List;

public class UserHeader {
	private String userName;
    private String userPassword;
    private UserViolationValidation violation;
    private Boolean menuViolation;
    
    
    
	public Boolean getMenuViolation() {
		return menuViolation;
	}
	public void setMenuViolation(Boolean menuViolation) {
		this.menuViolation = menuViolation;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public UserViolationValidation getViolation() {
		return violation;
	}
	public void setViolation(UserViolationValidation violation) {
		this.violation = violation;
	}
    
}
