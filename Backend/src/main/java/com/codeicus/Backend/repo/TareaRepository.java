package com.codeicus.Backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeicus.Backend.model.Tarea;

@Repository
public interface TareaRepository extends JpaRepository <Tarea, Integer> {   //Use JpaRepository y no crudrepository porque es mas completo

	//Ver si defino el metodo del detalle de una tarea.
	
}
