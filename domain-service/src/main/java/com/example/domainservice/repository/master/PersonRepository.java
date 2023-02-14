package com.example.domainservice.repository.master;

import java.util.*;

// Spring Data JPAを使わずにEntityManagerを操作したい
// import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domainmodel.model.master.*;

public interface PersonRepository {

	public List<Person> findAll();

	public Person findById(Long id);

	public void create(Person person);

	public void update(Person person);

	public void delete(Long id);

	public void sort(Dictionary<Long, Long> ids);

	public void save();
}
