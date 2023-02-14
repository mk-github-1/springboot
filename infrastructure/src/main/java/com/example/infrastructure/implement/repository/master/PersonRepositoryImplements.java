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
		// TODO Auto-generated method stub
		return new ArrayList<Person>();
	}

	public Person findById(Long id) {
		// TODO Auto-generated method stub
		return new Person();
	}

	public void create(Person person) {
		// TODO Auto-generated method stub
	}

	public void update(Person person) {
		// TODO Auto-generated method stub
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void sort(Dictionary<Long, Long> ids) {
		// TODO Auto-generated method stub
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
	}
}
