package com.example.infrastructure.implement.repository.account;

import com.example.domainmodel.model.account.Account;
import com.example.domainservice.repository.account.*;

/**
 * AccountRepositoryImplements
 *
 */
public class AccountRepositoryImplements implements AccountRepository {

    /**
	 * constructor
	 */
	public AccountRepositoryImplements () {

	}

    /**
	 * userNameからAccountを取得する
	 */
	@Override
	public Account findOne(String username) {
		return new Account();
	}
}
