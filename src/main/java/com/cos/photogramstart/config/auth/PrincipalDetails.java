package com.cos.photogramstart.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;


@Data
public class PrincipalDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collector = new ArrayList<>();
		collector.add(() -> { return user.getRole();});
		return collector;
	}

	@Override
	public String getPassword() {
		// TODO 자동 생성된 메소드 스텁
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO 자동 생성된 메소드 스텁
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO 자동 생성된 메소드 스텁
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO 자동 생성된 메소드 스텁
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO 자동 생성된 메소드 스텁
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO 자동 생성된 메소드 스텁
		return true;
	}
	

}
