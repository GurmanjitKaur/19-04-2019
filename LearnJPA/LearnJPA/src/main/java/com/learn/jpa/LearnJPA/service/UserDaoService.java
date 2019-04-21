package com.learn.jpa.LearnJPA.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.learn.jpa.LearnJPA.entity.User;

@Repository
//for opening, closing and maintaining transaction
@Transactional
public class UserDaoService {

	@PersistenceContext
	private EntityManager entityManager;

	public long save(User user) {
		entityManager.persist(user);
		return user.getId();
	}
}
