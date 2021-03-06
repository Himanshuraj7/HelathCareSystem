package com.capgemini.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.app.entity.Users;
import com.capgemini.app.exception.UserException;

@Repository
public class UserDaoImplementation implements UserDao{
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public boolean addUser(Users user) {
		em.persist(user);
		return true;
	}

	@Override
	public boolean login(String mailId, String password) throws UserException {
		String Qstr = "SELECT userPassword FROM Users user WHERE user.emailId="+mailId;
		TypedQuery<Users> query = em.createQuery(Qstr, Users.class);
		//Users users=em.find(Users.class, mailId);
		if(query==null) throw new UserException("User not registered");
		return true;
	}

//	@Override
//	public Users getPassword(String password) throws UserException {
//		Users users=em.find(Users.class, password);
//		if(users==null) throw new UserException("User Id or Password is invalid");
//		return users;
//	}
	
	

}
