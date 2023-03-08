package com.example.domainservice.repository.master;

import java.util.*;

import com.example.domainmodel.model.master.*;
import com.example.domainservice.GenericeRepository;

/**
 * PersonRepository
 *
 */
public interface PersonRepository extends GenericeRepository<Person> {

	public List<Person> findAll();

	public Person findById(Long id);

	public Person create(Person person);

	public Person update(Person person);

	public Person delete(Long id);

	public void sort(Dictionary<Long, Long> ids);
}
