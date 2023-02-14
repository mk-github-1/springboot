package com.example.userinterface.loginuser;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * LoginUserDetails
 */
public class LoginUserDetails implements UserDetails {

    /**
	 * LoginUserDetailsの識別用
	 */
	private static final long serialVersionUID = 1L;
	private final LoginUser loginUser;
    private final Collection<? extends GrantedAuthority> authorities;

    /**
	 * constructor
	 */
    public LoginUserDetails(LoginUser loginUser) {
        this.loginUser = loginUser;
        this.authorities = loginUser.roleList()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .toList();
    }

    public LoginUser getLoginUser() {
        return loginUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return loginUser.password();
    }

    @Override
    public String getUsername() {
        return loginUser.email();
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
}