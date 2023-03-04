package com.example.userinterface.account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * LoginUserDetails: 認証処理で必要となる資格情報(ユーザー名とパスワード)とユーザーの状態を提供するための実装
 */
public class AccountUserDetails implements UserDetails {

    /**
	 * LoginUserDetailsの識別用
	 */
	private static final long serialVersionUID = 1L;
	private final Account _account;
    private final Collection<GrantedAuthority> _authorities;

    /**
	 * constructor
	 */
    public AccountUserDetails(Account account, Collection<GrantedAuthority> authorities) {
        this._account = account;
        this._authorities = authorities;
    }

    /**
	 *
	 */
    public Account getAccount() {
        return this._account;
    }

    /**
	 *
	 */
    @Override
    public String getUsername() {
        return this._account.getEmail();
    }

    /**
	 *
	 */
    @Override
    public String getPassword() {
        return this._account.getPassword();
    }

    /**
	 *
	 */
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this._authorities;
    }

    /**
	 *
	 */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
	 *
	 */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
	 *
	 */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
	 *
	 */
    @Override
    public boolean isEnabled() {
        return true;
    }
}