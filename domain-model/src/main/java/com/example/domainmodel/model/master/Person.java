package com.example.domainmodel.model.master;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Person
 *　※@Setterは使用しないで下さい
 */
@Entity
@Table(name="person")
@Getter
@EqualsAndHashCode
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	@Column(length = 256, nullable = false)
	private String name;

	@Column(length = 256, nullable = true)
	private String email;

	@Column(nullable = true)
	private Integer age;

	@Column(length = 256, nullable = true)
	private String remarks;

	@Column(nullable = true)
	private Integer old_id;

	@Column(nullable = false)
	private Integer order;

	@Column(nullable = false)
	private Date created_at;

	@Column(nullable = false)
	private Date updated_at;

	@Version
	@Column(nullable = false)
	private Timestamp version;

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