package com.example.userinterface.account;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.domainmodel.model.account.Account;

/**
 * 資格情報とユーザーの状態をデータストアから取得するためのUserDetailsServiceの実装
 *
 * 'Spring徹底入門'を引用
 */
@Service
public class AccountUserDetailsService implements UserDetailsService {
	private final AccountRepository accountRepository;

    /**
	 * constructor
	 */
	public AccountUserDetailsService (AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

    /**
	 * データベースからアカウント情報を検索する
	 * アカウント情報が見つからない場合、UserNameNotFountExceptionをスローする
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = Optional.ofNullable(accountRepository.findOne(username))
        	.orElseThrow(() -> new UsernameNotFoundException("user not found"));

		//　アカウント情報が見つかった場合はUserDetailsを生成する
        return new AccountUserDetails(account, getAuthorities(account));
	}

    /**
	 * ユーザーが補助する権限情報(ロール)を生成す。
	 * ここで生成した権限情報は認可処理で使用される
	 */
	private Collection<GrantedAuthority> getAuthorities(Account account) {
		// Springではロールに”ROLE_”プレフィックスを設定する必要があります
		if (account.isAdmin()) {
			return AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMINISTRATOR");
		} else {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}
	}
}
