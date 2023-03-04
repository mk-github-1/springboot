package com.example.userinterface.account;

import java.util.List;

import lombok.Getter;

@Getter
public class Account {

	public String email;

	public String name;

	public String password;

	public List<String> roleList;
	
	public Boolean isAdmin() {
		return true;
	}
}
