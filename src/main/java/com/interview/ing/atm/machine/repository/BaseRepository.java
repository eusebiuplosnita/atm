package com.interview.ing.atm.machine.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.data.repository.CrudRepository;

/**
 * Defines a way to do the basic operations to the repository without re-writing the methods in all repository classes.
 * 
 * @param <R> The domain class.
 * @param <S> The entity class.
 * @param <T> The type of the identity for CrudRepository.
 */
public abstract class BaseRepository<R,S,T> {
	
	private Class<R> domainClass;
	
	private Class<S> entityClass;
	
	private ModelMapper mapper;
	
	protected BaseRepository(Class<R> domainClass, Class<S> entityClass) {
		this.domainClass = domainClass;
		this.entityClass = entityClass;
	}
	
	protected abstract CrudRepository<S,T> getRepository();
	
	public R findById(T id) {
		Optional<S> entity = getRepository().findById(id);
		return mapper.map(entity.get(), this.domainClass);
	}
	
	public List<R> findAll() {
		return StreamSupport.stream(this.getRepository().findAll().spliterator(), false)
				.map(entity -> mapper.map(entity, this.domainClass)).collect(Collectors.toList());
	}
	
	public R save(R domainObject) {
		if (domainObject == null) {
			throw new IllegalArgumentException("The object to be saved is null!");
		}
		
		S savedEntity = this.getRepository().save(mapper.map(domainObject, this.entityClass));
		return mapper.map(savedEntity, this.domainClass);
	}
	
	public void deleteById(T id) {
		if (id == null) {
			throw new IllegalArgumentException("The id of the object to be deleted cannot be null!");
		}
		this.getRepository().deleteById(id);
	}
}
