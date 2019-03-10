package com.codeicus.Backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.codeicus.Backend.model.Tarea;

@CrossOrigin(origins= "http://localhost:4200")
@Repository
public interface TareaRepository extends JpaRepository <Tarea, Integer> {   //Use JpaRepository y no crudrepository porque es mas completo

}

