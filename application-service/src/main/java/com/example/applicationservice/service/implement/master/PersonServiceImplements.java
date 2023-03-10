package com.example.applicationservice.service.implement.master;

import java.util.*;

// import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.example.applicationservice.service.master.*;
import com.example.domainmodel.model.master.*;
import com.example.domainservice.repository.master.*;
// import com.example.infrastructure.implement.repository.master.*;

// コードはコンパイルを通すための下書きです。

/**
 * PersonServiceImplements
 *　
 */
// @EnableConfigurationProperties(PersonServiceImplements.class)
@Async
@Service
@Transactional
public class PersonServiceImplements implements PersonService {

	private final PersonRepository _personRepository;

    /**
	 * constructor
	 */
	public PersonServiceImplements(PersonRepository personRepository) {
		this._personRepository = personRepository;
	}

	public List<Person> findAll() {
		return this._personRepository.findAll();
	}

	public Person findById(Long id) {
		return this._personRepository.findById(id);
	}

	public void create(Person person) {
		this._personRepository.create(person);
	}

	public void edit(Person person) {
		this._personRepository.update(person);
	}

	public void delete(Long id) {
		this._personRepository.delete(id);
	}

	public void sort(Dictionary<Long, Long> ids) {
		this._personRepository.sort(ids);
	}
}
