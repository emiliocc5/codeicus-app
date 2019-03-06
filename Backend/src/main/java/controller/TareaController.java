package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repo.TareaRepository;

@CrossOrigin(origins = "http://localhost:4200")


@RestController
@RequestMapping ("/tarea")
public class TareaController {
	
	@Autowired
	TareaRepository repository;

}
