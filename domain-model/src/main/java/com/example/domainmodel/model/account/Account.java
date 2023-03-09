package com.example.domainmodel.model.account;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
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
	private Date created_at;

	@Column(nullable = false)
	private Date updated_at;

	@Version
	@Column(nullable = false)
	private Timestamp version;

	@OneToMany
	private List<String> roleList;

	public Boolean isAdmin() {
		return true;
	}

	@PrePersist
    public void prePersist() {
        Date date = new Date();
        created_at = date;
        updated_at = date;
    }

    @PreUpdate
    public void preUpdate() {
    	updated_at = new Date();
    }
}
