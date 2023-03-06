package com.example.applicationservice.service.implement.master;

import java.util.*;

import org.springframework.stereotype.Service;
//import org.springframework.orm.hibernate.HibernateTransactionManager;

import com.example.applicationservice.service.master.*;
import com.example.domainmodel.model.master.*;
import com.example.domainservice.repository.master.*;

// コードはコンパイルを通すための下書きです。

//@Transactional
@Service
public class PersonServiceImplements implements PersonService {

	private final PersonRepository _personRepository;

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
		this._personRepository.save();
	}

	public void edit(Person person) {
		this._personRepository.update(person);
		this._personRepository.save();
	}

	public void delete(Long id) {
		this._personRepository.delete(id);
		this._personRepository.save();
	}

	public void sort(Dictionary<Long, Long> ids) {
		this._personRepository.sort(ids);
		this._personRepository.save();
	}
}
