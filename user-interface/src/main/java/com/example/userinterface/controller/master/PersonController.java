package com.example.userinterface.controller.master;

import java.util.*;

import org.springframework.web.bind.annotation.RestController;

import com.example.applicationservice.service.master.*;
import com.example.domainmodel.model.master.*;

// コードはコンパイルを通すための下書きです。

@RestController
public class PersonController {

	private final PersonService _personService;

	public PersonController(PersonService personService) {
		this._personService = personService;
	}

	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return this._personService.findAll();
	}

	public Person findById(Long id) {
		// TODO Auto-generated method stub
		return this._personService.findById(id);
	}

	public void create(Person person) {
		// TODO Auto-generated method stub
		this._personService.create(person);
	}

	public void edit(Person person) {
		// TODO Auto-generated method stub
		this._personService.edit(person);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		this._personService.delete(id);
	}

	public void sort(Dictionary<Long, Long> ids) {
		// TODO Auto-generated method stub
		this._personService.sort(ids);
	}
}
