package com.example.infrastructure.implement.repository.master;

import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

// import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.example.domainmodel.model.master.*;
import com.example.domainservice.repository.master.*;

// コードはコンパイルを通すための下書きです。

/**
 * PersonRepositoryImplements
 *
 */
//@EnableConfigurationProperties(PersonRepositoryImplements.class)
@Async
@Repository
public class PersonRepositoryImplements implements PersonRepository {

	@PersistenceContext
	public EntityManager entityManager;

    /**
	 * constructor
	 */
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

		// setterがだめならmergeしかないが競合チェックができるかわからない
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
		// SQLは下書き
		Query query = entityManager.createQuery("UPDATE [dbo].[m_persons] \"\r\n"
			+ " SET [order] = B.[order] \"\r\n"
			+ " FROM [dbo].[m_persons] AS A \"\r\n"
			+ " LEFT OUTER JOIN ( \"\r\n"
			+ "    SELECT C.[id], ROW_NUMBER() OVER ( \"\r\n"
			+ "        ORDER BY \"\r\n"
			+ "            C.[is_deleted] ASC, \"\r\n"
			+ "            D.[order] ASC, \"\r\n"
			+ "            C.[updated_at] DESC \"\r\n"
			+ "     ) AS 'Order' \"\r\n"
			+ "     FROM [dbo].[m_persons] AS C \"\r\n"
			+ "     LEFT OUTER JOIN @temp AS D \"\r\n"
			+ "     ON C.[Id] = D.[Id] \"\r\n"
			+ " ) AS B \"\r\n"
			+ " ON A.[Id] = B.[Id] \"\r\n"
			+ " WHERE B.[Id] IS NOT NULL");

		query.getResultList();
	}
}
