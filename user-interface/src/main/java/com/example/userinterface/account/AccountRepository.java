package com.example.userinterface.account;

import org.springframework.stereotype.Repository;

import com.example.domainmodel.model.account.Account;

/**
 * Account情報にアクセスするRepository、インタフェースがない？
 *
 */

@Repository
public class AccountRepository {

    /**
	 * constructor
	 */
	public AccountRepository () {

	}

    /**
	 * userNameからAccountを取得する
	 */
	public Account findOne(String username) {
		return new Account();
	}
}
