package com.sitespace.fileupload.usermanagement;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String userId;

	private String username;

	private String email;
	
	private Integer creditPoint;
	
	private String role;


	public Integer getCreditPoint() {
		return creditPoint;
	}

	public void setCreditPoint(Integer creditPoint) {
		this.creditPoint = creditPoint;
	}

	@JsonIgnore
	private String password;

	private static Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id,String userId, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities,Integer creditPoint,String role) {
		this.id = id;
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		this.creditPoint = creditPoint;
		this.role = role ;

	}

	public static UserDetailsImpl build(User user) {
		
		  
		  return new UserDetailsImpl( user.getId(),user.getUserId(), user.getUsername(),
		  user.getEmail(), user.getPassword(), authorities,user.getCreditpoint(),user.getRole());
		 }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}
	
	public String getUserId() {
		return userId;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	public UserDetailsImpl(String userId, String email) {
		this.userId = userId;
		this.email = email;
	}
	

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
