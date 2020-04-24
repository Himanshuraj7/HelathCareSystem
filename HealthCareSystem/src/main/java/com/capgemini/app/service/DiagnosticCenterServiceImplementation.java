package com.capgemini.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.dao.DiagnosticCenterDao;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
import com.capgemini.app.exception.InvalidException;
import com.capgemini.app.exception.NullException;
import com.capgemini.app.exception.WrongValueException;

@Service
@Transactional
public class DiagnosticCenterServiceImplementation implements DiagnosticCenterService{
	
	@Autowired
	private DiagnosticCenterDao centerDao;

	@Override
	public boolean addCenter(DiagnosticCenter center) {
		if(centerDao.addCenter(center))
			return true;
		else
			throw new InvalidException("center name must have atleast 3 charcters and atmost 15 charcters");
	}

	@Override
	public boolean removeCenter(long id) {
		if( centerDao.removeCenter(id))
			return true;
		else
			throw new WrongValueException("center doesn't exist");
	}

	@Override
	public List<DiagnosticCenter> getAllCenter() {
		if(centerDao.getAllCenter()!=null)
			return centerDao.getAllCenter();
		else
			throw new NullException("Ooops!!!There is no center");
	}

	@Override
	public DiagnosticCenter getCenter(long centerId) {
		if(centerDao.getCenter(centerId)!=null)
			return centerDao.getCenter(centerId);
		else 
			throw new NullException("Ooops!!!There is no center with this centerId");
	}

	@Override
	public List<Test> getTest(long centerId) {
		if(centerDao.getCenter(centerId)!=null)
			return centerDao.getTest(centerId);
		else 
			throw new NullException("Ooops!!!There is no center with this centerId");
	}

	@Override
	public List<Test> getAllTest() {
		if(centerDao.getAllTest()!=null)
			return centerDao.getAllTest();
		else
			throw new NullException("Ooops!!!There is no test");
			
	}
	

}