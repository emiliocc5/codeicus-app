package com.codeicus.Backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.codeicus.Backend.model.Log;

@CrossOrigin(origins= "http://localhost:4200")
@Repository
public interface LogRepository extends JpaRepository <Log, Integer> {
	
}
