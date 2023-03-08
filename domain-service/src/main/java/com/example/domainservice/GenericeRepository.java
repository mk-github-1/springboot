package com.example.domainservice;

import java.util.Dictionary;
import java.util.List;

/**
 * GenericeRepository
 *　
 */
public interface GenericeRepository {
	public List<?> findAll();

	// public T findById(Long id);

	// public T create(T model);

	// public T update(T model);

	// public T delete(Long id);

	public void sort(Dictionary<Long, Long> ids);
}
