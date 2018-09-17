package com.attendance_tracker.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthorityDetails extends AbstractAuthenticationToken {

	private static final long serialVersionUID = 1L;

	private String token;
	private final UserDetails principal;

	public AuthorityDetails(UserDetails principal) {
		super(principal.getAuthorities());
		this.principal = principal;
	}

	public AuthorityDetails(UserDetails userDetails, String token) {
		this(userDetails);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public boolean isAuthenticated() {
		return true;
	}

	@Override
	public Object getCredentials() {
		return getToken();
	}

	@Override
	public UserDetails getPrincipal() {
		return principal;
	}

}
