package com.example.infrastructure.implement.repository.master;

import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.example.domainmodel.model.master.*;
import com.example.domainservice.repository.master.*;

// コードはコンパイルを通すための下書きです。

/**
 * PersonRepositoryImplements
 *
 */
@Async
@Repository
public class PersonRepositoryImplements implements PersonRepository {

	@PersistenceContext
	public EntityManager entityManager;

	public PersonRepositoryImplements() {
		super();
	}

	@Override
	public List<Person> findAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);

		Root<Person> root = criteriaQuery.from(Person.class);
		criteriaQuery.select(root);
		List<Person> persons = (List<Person>)entityManager.createQuery(criteriaQuery).getResultList();

		return persons;
	}

	@Override
	public Person findById(Long id) {
		Person person = (Person)entityManager.find(Person.class, id);
		return person;
	}

	@Override
	public Person create(Person person) {
		entityManager.persist(person);
		return person;
	}

	@Override
	public Person update(Person person) {
		/*
		Person r = (Person)entityManager.find(Person.class, person.getId());

		Person r2 = new Person(
			person.getId(),
			person.getName(),
			person.getEmail(),
			person.getAge(),
			person.getRemarks(),
			person.getOld_id(),
			person.getOrder(),
			person.getCreated_at(),
			person.getUpdated_at()
		);
         */

		// setterがだめならmergeしかない
		entityManager.merge(person);

		return person;
	}

	@Override
	public Person delete(Long id) {
		Person person = (Person)entityManager.find(Person.class, id);
		entityManager.remove(person);

		return person;
	}

	@Override
	public void sort(Dictionary<Long, Long> ids) {
		// SQLで書く

	}
}
