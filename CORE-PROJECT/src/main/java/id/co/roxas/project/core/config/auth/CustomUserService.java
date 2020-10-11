package id.co.roxas.project.core.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import id.co.roxas.common.lib.user.UserDetail;


public class CustomUserService implements UserDetails {

	private static final long serialVersionUID = -2429991675050040356L;

	private UserDetail userDetail;
	private List<GrantedAuthority> grantType = new ArrayList<>();
	private String roleCode;

	
	
	public CustomUserService() {
		super();
	}

	public CustomUserService(UserDetail userDetail) {
		this.userDetail = userDetail;
		this.roleCode = "hai";
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public String getRoleCode() {
		return roleCode;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantType;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return "{noop}" + userDetail.getUserPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userDetail.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return userDetail.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return userDetail.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return userDetail.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return userDetail.isEnabled();
	}

}
