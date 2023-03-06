package com.example.domainmodel.model.master;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Personモデル
 *　
 * ※@Setterは使用しないで下さい
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
	private LocalDateTime created_at;

	@Column(nullable = false)
	private LocalDateTime updated_at;
}