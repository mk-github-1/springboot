package com.example.domainservice.repository.master;

import java.util.*;

import com.example.domainmodel.model.master.*;

/**
 * PersonRepository
 *
 */
public interface PersonRepository {

	public List<Person> findAll();

	public Person findById(Long id);

	public Person create(Person person);

	public Person update(Person person);

	public Person delete(Long id);

	public void sort(Dictionary<Long, Long> ids);
}
