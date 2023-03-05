package com.example.domainmodel.model.master;

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

	@SuppressWarnings("unused")
	private int id;

	@SuppressWarnings("unused")
	private String name;

	@SuppressWarnings("unused")
	private int age;
}