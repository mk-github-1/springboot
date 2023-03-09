package com.example.infrastructure.implement.repository.account;

import com.example.domainmodel.model.account.Account;
import com.example.domainservice.repository.account.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * AccountRepositoryImplements
 *
 */
public class AccountRepositoryImplements implements AccountRepository {

	@PersistenceContext
	public EntityManager entityManager;

    /**
	 * constructor
	 */
	public AccountRepositoryImplements () {
		super();
	}

    /**
	 * userNameからAccountを取得する
	 */
	@Override
	public Account findOne(String username) {
		return new Account();
	}
}
