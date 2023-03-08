package com.example.domainservice.repository.account;

import com.example.domainmodel.model.account.*;

/**
 * Account情報にアクセスするRepository
 *
 */
public interface AccountRepository {
	public Account findOne(String username);
}
