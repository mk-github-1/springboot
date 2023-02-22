package com.example.applicationservice.service.master;

import java.util.*;

import com.example.domainmodel.model.master.*;

public interface PersonService {
	public List<Person> findAll();

	public Person findById(Long id);

	public void create(Person person);

	public void edit(Person person);

	public void delete(Long id);

	public void sort(Dictionary<Long, Long> ids);
}
