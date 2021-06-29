package br.uniceub.healthnote.service.abstrato;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<T, I> implements IBaseService<T, I>{

	protected abstract JpaRepository<T, I> getRepository();	
		
	@Override
	public List<T> findAll() {
		return this.getRepository().findAll();
	}

	@Override
	public List<T> findAll(Sort sort) {
		return this.getRepository().findAll(sort);
	}

	@Override
	public List<T> findAllById(Iterable<I> ids) {
		return this.getRepository().findAllById(ids);
	}

	@Override
	public <S extends T> List<S> saveAll(Iterable<S> entities) {
		return this.getRepository().saveAll(entities);
	}

	@Override
	public void flush() {
		this.getRepository().flush();
	}

	@Override
	public <S extends T> S saveAndFlush(S entity) {
		return this.getRepository().saveAndFlush(entity);
	}

	@Override
	public <S extends T> List<S> saveAllAndFlush(Iterable<S> entities) {
		return this.getRepository().saveAllAndFlush(entities);
	}

	@Override
	public void deleteAllInBatch(Iterable<T> entities) {
		this.getRepository().deleteAllInBatch(entities);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<I> ids) {
		this.getRepository().deleteAllByIdInBatch(ids);		
	}

	@Override
	public void deleteAllInBatch() {
		this.getRepository().deleteAllInBatch();		
	}

	@Override
	public T getOne(I id) {
		return this.getRepository().getOne(id);
	}

	@Override
	public T getById(I id) {
		return this.getRepository().getById(id);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example) {
		return this.getRepository().findAll(example);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		return this.getRepository().findAll(example, sort);
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return this.getRepository().findAll(pageable);
	}

	@Override
	public <S extends T> S save(S entity) {
		return this.getRepository().save(entity);
	}

	@Override
	public Optional<T> findById(I id) {
		return this.getRepository().findById(id);
	}

	@Override
	public boolean existsById(I id) {
		return this.getRepository().existsById(id);
	}

	@Override
	public long count() {
		return this.getRepository().count();
	}

	@Override
	public void deleteById(I id) {
		this.getRepository().deleteById(id);		
	}

	@Override
	public void delete(T entity) {
		this.getRepository().delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends I> ids) {
		this.getRepository().deleteAllById(ids);		
	}

	@Override
	public void deleteAll(Iterable<? extends T> entities) {
		this.getRepository().deleteAll();		
	}

	@Override
	public void deleteAll() {
		this.getRepository().deleteAll();		
	}

	@Override
	public <S extends T> Optional<S> findOne(Example<S> example) {
		return this.getRepository().findOne(example);
	}

	@Override
	public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
		return this.getRepository().findAll(example, pageable);
	}

	@Override
	public <S extends T> long count(Example<S> example) {
		return this.getRepository().count(example);
	}

	@Override
	public <S extends T> boolean exists(Example<S> example) {
		return this.getRepository().exists(example);
	}
	
	

}
