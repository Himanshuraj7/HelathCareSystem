package com.capgemini.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.dto.TestDto;
import com.capgemini.app.entities.DiagnosticCenter;
import com.capgemini.app.entities.Test;
import com.capgemini.app.exceptions.TestException;
import com.capgemini.app.service.TestService;

/************************************************************************************
 * 			@author 		Vishal Mawani
 * 
 *         Description 		Test controller class which provides functionality of
 *         					adding a test, removing a test, viewing diagnostic centers and
 *        					handles the corresponding exceptions.
 * 
 *         Created Date 	27-APR-2020
 ************************************************************************************/
@CrossOrigin
@RestController
public class TestController {

	@Autowired
	TestService testService;

	/************************************************************************************
	 * Method: addCenter
     *Description: 			To view center and tests present under it
	 * @param testdto        - testdto object which return center object.
	 * @returns boolean      - if centerId added
	 * @throws TestException - It is raised due to invalid data.
	 ************************************************************************************/
	@PostMapping("/addCenter")
	public boolean addCenter(@RequestBody TestDto testDto) throws TestException {
		try {
			testService.addCenter(testDto);
			return true;
		} catch (Exception exception) {
			throw new TestException(exception.getMessage());
		}

	}
	
	/************************************************************************************
	 * Method: addTest
     *Description: 			To add a test under a particular diagnostic center.
	 * @param centerId       - center's id
	 * @param test			 - test Object
	 * @returns String       - Test Added.
	 * @throws TestException - It is raised if test already exists.
	 ************************************************************************************/
	@PostMapping("/addTest/{centerId}")
	public String addTest(@PathVariable long centerId, @RequestBody Test test) throws TestException {
		try {
			return testService.addTest(centerId, test);
		} catch (Exception exception) {
			throw new TestException(exception.getMessage());
		}
	}

	/************************************************************************************
	 * Method: removeTest
     *Description: 			To remove a particular test under a diagnostic center
	 * @param testId         - test id
	 * @returns String       - Test deleted.
	 * @throws TestException - Test already exists.
	 ************************************************************************************/
	@DeleteMapping("/removeTest/{testId}")
	public String removeTest(@PathVariable long testId) throws TestException {
		try {
			return testService.removeTest(testId);
		} catch (Exception exception) {
			throw new TestException(exception.getMessage());
		}

	}

	/************************************************************************************
	 * Method: getAllCenter
     *Description: To get all diagnostic center available.
	 * @returns List		 - Type Diagnostic Center.
	 * @throws TestException - Diagnostic Centers not present.
	 ************************************************************************************/
	
	@GetMapping("/centers")
	public List<DiagnosticCenter> getAllCenter() throws TestException {
		try{
			return testService.getAllCenter();
		}catch (Exception exception) {
			throw new TestException(exception.getMessage());
		}
	}

	/************************************************************************************
	 * Method: getCenter
     *Description: To get a particular diagnostic center available along with its tests.
	 * @returns Object		 - Type Diagnostic Center.
	 * @throws TestException - Diagnostic Center not found.
	 ************************************************************************************/
	@GetMapping("/center/{centerId}")
	public DiagnosticCenter getCenter(@PathVariable long centerId) throws TestException {
		try{
			return testService.getCenter(centerId);
		}catch (Exception exception) {
			throw new TestException(exception.getMessage());
		}
	}
}
