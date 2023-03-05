package com.example.userinterface.account;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Accountモデル
 *　
 * ※@Setterは使用しないで下さい
 */
@Getter
@EqualsAndHashCode
public class Account {

	private String email;

	private String name;

	private String password;

	private List<String> roleList;

	public Boolean isAdmin() {
		return true;
	}
}
