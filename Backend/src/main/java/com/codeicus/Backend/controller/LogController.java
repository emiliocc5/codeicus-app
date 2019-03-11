package com.codeicus.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeicus.Backend.model.Log;
import com.codeicus.Backend.repo.LogRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/codeicus")
public class LogController {

	@Autowired
	private LogRepository repo;
	
	@GetMapping("/listarLogs")
	public Iterable<Log> listarLog() {
		return repo.findAll();

		// @deletemapping borrar todos los logs throws nologexception

	}
}
