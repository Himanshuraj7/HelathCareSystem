package com.capgemini.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.dao.UserDao;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Users;
import com.capgemini.exception.UserException;

@Transactional
@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean addUser(Users user) {
		return userDao.addUser(user);
	}

	@Override
	public Users getMailId(String mailId) throws UserException {
		return userDao.getMailId(mailId);
	}

	@Override
	public Users getPassword(String password) throws UserException {
		return userDao.getPassword(password);
	}

}
