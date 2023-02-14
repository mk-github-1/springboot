package com.example.applicationservice.service.implement.master;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.applicationservice.service.master.*;
import com.example.domainmodel.model.master.*;
import com.example.domainservice.repository.master.*;

// コードはコンパイルを通すための下書きです。

@Service
public class PersonServiceImplements implements PersonService {

	private final PersonRepository _personRepository;

	public PersonServiceImplements(PersonRepository personRepository) {
		this._personRepository = personRepository;
	}

	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return this._personRepository.findAll();
	}

	public Person findById(Long id) {
		// TODO Auto-generated method stub
		return this._personRepository.findById(id);
	}

	public void create(Person person) {
		// TODO Auto-generated method stub
		this._personRepository.create(person);
		this._personRepository.save();
	}

	public void edit(Person person) {
		// TODO Auto-generated method stub
		this._personRepository.update(person);
		this._personRepository.save();
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		this._personRepository.delete(id);
		this._personRepository.save();
	}

	public void sort(Dictionary<Long, Long> ids) {
		// TODO Auto-generated method stub
		this._personRepository.sort(ids);
		this._personRepository.save();
	}
}
