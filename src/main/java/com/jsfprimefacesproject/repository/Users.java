package com.jsfprimefacesproject.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jsfprimefacesproject.model.User;

public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Users() {

	}

	public Users(EntityManager manager) {
		this.manager = manager;
	}

	public User porId(Long id) {
		return manager.find(User.class, id);
	}

	public List<User> pesquisar(String nome) {
		String jpql = "from User where fullname like :fullname";
		
		TypedQuery<User> query = manager
				.createQuery(jpql, User.class);
		
		query.setParameter("fullname", nome + "%");
		
		return query.getResultList();
	}
	
	public List<User> todas() {
         return manager.createQuery("from User", User.class).getResultList();
    }

	public User guardar(User user) {
		return manager.merge(user);
	}

	public void remover(User user) {
		user = porId(user.getId());
		manager.remove(user);
	}
}