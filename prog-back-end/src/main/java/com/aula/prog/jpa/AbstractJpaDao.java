package com.aula.prog.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaDao< T extends Serializable > {
	 
	private Class< T > clazz;
	 
	@PersistenceContext
	private EntityManager entityManager;
	 
	public void setClazz( Class< T > clazzToSet ) {
		this.clazz = clazzToSet;
	}
	 
	public T findOne( Long id ){
		return entityManager.find( clazz, id );
	}
	
	public List< T > findAll(){
		return entityManager.createQuery( "from " + clazz.getName() ).getResultList();
	}
	 
	public void save( T entity ){
		entityManager.persist( entity );
	}
	 
	public void update( T entity ){
		entityManager.merge( entity );
	}
	 
	public void delete( T entity ){
		entityManager.remove( entity );
	}
}