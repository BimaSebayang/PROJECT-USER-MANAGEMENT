package id.co.roxas.project.core.controller.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.roxas.common.lib.user.UserHeader;

@RestController
@RequestMapping("/auth")
public class AuthenticationCtl {

	@GetMapping("/checkAuth")
	public ResponseEntity<Boolean> checkAuth(Authentication authentication) {
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
}
