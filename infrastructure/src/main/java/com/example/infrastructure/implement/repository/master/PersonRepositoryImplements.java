package com.example.infrastructure.implement.repository.master;

import java.util.*;

// import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.domainmodel.model.master.*;
import com.example.domainservice.repository.master.*;

// コードはコンパイルを通すための下書きです。
// Spring Data JPA　と Hibernateは別物？Repositoryは標準でなく独自に使いたい

@Repository
public class PersonRepositoryImplements implements PersonRepository {

	public PersonRepositoryImplements() {

	}

	public List<Person> findAll() {
		return new ArrayList<Person>();
	}

	public Person findById(Long id) {
		return new Person();
	}

	public void create(Person person) {

	}

	public void update(Person person) {

	}

	public void delete(Long id) {
	}

	@Override
	public void sort(Dictionary<Long, Long> ids) {
	}

	@Override
	public void save() {

	}
}
