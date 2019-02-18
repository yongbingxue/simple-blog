package com.yongbingxue.blog.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericService {

	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
