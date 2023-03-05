package com.example.userinterface.account;

import org.springframework.stereotype.Repository;

/**
 * Account情報にアクセスするRepository、インタフェースがない？
 *
 */

@Repository
public class AccountRepository {


	public Account findOne(String username) {
		return new Account();
	}
}
