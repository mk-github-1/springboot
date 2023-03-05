package com.example.userinterface.account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 認証処理で必要となる資格情報(ユーザー名とパスワード)とユーザーの状態を提供するためのUserDetailsの実装
 * 
 * 'Spring徹底入門'を引用
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
	 *　ユーザー名を返却する
	 */
    @Override
    public String getUsername() {
        return this._account.getEmail();
    }

    /**
	 *　登録されているパスワードを返却する
	 *　一致しない場合、DaoAuthenticationProviderがBadCredentialsExceptionをスローする
	 */
    @Override
    public String getPassword() {
        return this._account.getPassword();
    }

    /**
	 *　有効なユーザーか判定する
	 *　無効なユーザーの場合、DaoAuthenticationProviderがDisabledExceptionをスローする
	 */
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this._authorities;
    }

    /**
	 * アカウントのロック状態を判定する
	 * アカウントがロックされいる場合、DaoAuthenticationProviderがLockedExceptionをスローする
	 */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
	 * アカウントの有効期限の状態を判定する
	 * 有効期限切れの場合、DaoAuthenticationProviderがAccountExpiredExceptionをスローする
	 */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
	 * 資格情報の有効期限の状態を判定する
	 * 有効期限切れの場合、DaoAuthenticationProviderがCredentialExpiredExceptionをスローする
	 */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
	 * ユーザーに与えられている権限リストを返却する
	 * 認可処理で利用する
	 */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
	 * 認証処理成功後の処理でアカウント情報にアクセスできるようにするため、getを用意する
	 */
    public Account getAccount() {
        return this._account;
    }
}