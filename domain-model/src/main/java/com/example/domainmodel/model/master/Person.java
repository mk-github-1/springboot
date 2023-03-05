package com.example.domainmodel.model.master;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Personモデル
 *　
 * ※@Setterは使用しないで下さい
 */

@Getter
@EqualsAndHashCode
public class Person {

	private int id;

	private String name;

	private int age;

	private String remarks;

	private int old_id;

	private int order;

	private LocalDateTime created_at;

	private LocalDateTime updated_at;
}