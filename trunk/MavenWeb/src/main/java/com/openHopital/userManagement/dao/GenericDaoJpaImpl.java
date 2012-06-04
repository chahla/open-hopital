package com.openHopital.userManagement.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class GenericDaoJpaImpl<T> implements GenericDao<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> type;

	public GenericDaoJpaImpl() {
		Type t = getClass().getGenericSuperclass();

		ParameterizedType pt = (ParameterizedType) t;
		System.out.println(pt.getActualTypeArguments()[0].getClass().getName());
		type = (Class) pt.getActualTypeArguments()[0];
	}

	public long countAll(final Map<String, Object> params) {

		final StringBuffer queryString = new StringBuffer(
				"SELECT count(o) from ");

		queryString.append(type.getSimpleName()).append(" o ");
		// queryString.append(this.getQueryClauses(params, null));

		final Query query = this.entityManager.createQuery(queryString
				.toString());

		return (Long) query.getSingleResult();

	}

	public T create(final T t) {
		this.entityManager.merge(t);
		return t;
	}

	public void delete(final Object id) {
		this.entityManager.remove(this.entityManager.getReference(type, id));
	}

	public T find(final Object id) {
		return this.entityManager.find(type, id);
	}

	public T update(final T t) {
		return this.entityManager.merge(t);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
