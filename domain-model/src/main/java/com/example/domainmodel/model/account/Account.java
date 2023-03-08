package com.example.domainmodel.model.account;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Accountモデル
 * ※@Setterは使用しないで下さい
 */
@Entity
@Table(name="login_user")
@Getter
@EqualsAndHashCode
public class Account {

	@Id
	@Column(length = 256)
	private String email;

	@Column(length = 256, nullable = false)
	private String name;

	@Column(length = 256, nullable = false)
	private String password;

	@Column(nullable = false)
	private LocalDateTime created_at;

	@Column(nullable = false)
	private LocalDateTime updated_at;

	@OneToMany
	private List<String> roleList;

	public Boolean isAdmin() {
		return true;
	}
}
