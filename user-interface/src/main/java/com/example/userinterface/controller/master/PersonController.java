package com.example.userinterface.controller.master;

import java.util.*;

import org.springframework.web.bind.annotation.RestController;

import com.example.applicationservice.service.master.*;
import com.example.domainmodel.model.master.*;

// コードはコンパイルを通すための下書きです。

// @RestController
public class PersonController {

	private final PersonService _personService;

	public PersonController(PersonService personService) {
		this._personService = personService;
	}

	// 一旦、@RestControllerをOFFにしているので画面を返したい
	public String index() {
		return "/person.html";
	}

	public List<Person> findAll() {
		return this._personService.findAll();
	}

	public Person findById(Long id) {
		return this._personService.findById(id);
	}

	public void create(Person person) {
		this._personService.create(person);
	}

	public void edit(Person person) {
		this._personService.edit(person);
	}

	public void delete(Long id) {
		this._personService.delete(id);
	}

	public void sort(Dictionary<Long, Long> ids) {
		this._personService.sort(ids);
	}
}
