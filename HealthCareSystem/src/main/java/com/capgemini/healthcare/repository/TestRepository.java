package com.capgemini.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test,Long>{
	
}