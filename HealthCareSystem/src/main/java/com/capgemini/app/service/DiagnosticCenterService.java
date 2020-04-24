package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;

public interface DiagnosticCenterService {
	
	boolean addCenter(DiagnosticCenter center);
	
	boolean removeCenter(long id);
	
	List<DiagnosticCenter> getAllCenter();
	
	DiagnosticCenter getCenter(long centerId);
	
	List<Test> getAllTest();
	
	List<Test> getTest(long id);

}