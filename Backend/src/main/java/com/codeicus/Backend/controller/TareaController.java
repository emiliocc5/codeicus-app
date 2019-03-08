package com.codeicus.Backend.controller;


import java.io.Console;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeicus.Backend.exception.TareaNotFoundException;
import com.codeicus.Backend.model.Tarea;
import com.codeicus.Backend.repo.TareaRepository;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping ("/codeicus")
public class TareaController {
	
	@Autowired
	private TareaRepository repository;
	
	
	//LISTAR TODAS LAS TAREAS
	
	@GetMapping("/listarTareas")
    public List<Tarea> listarTareas() { //Throws NingunaTareaException si no encuentra ninguna tarea
        return repository.findAll();      
    }
	
	//OBTENER UNA TAREA
	
	@GetMapping ("/getTarea/{id}")
	public Tarea detalleTarea(@PathVariable(value = "id") int id) throws TareaNotFoundException {
		final Optional<Tarea> TareaOptional= repository.findById(id);
		if (!TareaOptional.isPresent()) {
			System.out.println("No se encontro la tarea con id" + id);
			throw new TareaNotFoundException(id);
		}
		return TareaOptional.get();
				
	}
	
	
	//CREAR NUEVA TAREA
	
	@PostMapping ("/crearTarea")
	public Tarea crearTarea(@RequestBody Tarea tarea) {
		return repository.save(tarea);	
	}
	
	//MODIFICAR UNA TAREA
	
	@PutMapping ("/modificarTarea/{id}")
	public ResponseEntity<Tarea> modificarTarea(@PathVariable int id, @Valid @RequestBody Tarea tarea) { //throws TareaNotFoundException
		Optional<Tarea> ta = repository.findById(id);

		 if (ta.isPresent()) {
			 Tarea _tarea = ta.get();
			 if(tarea.getDetalle()!= null) {
			 _tarea.setDetalle(tarea.getDetalle());}
			 if (tarea.getEstado()!=null) {
			 _tarea.setEstado(tarea.getEstado());}
			 if (tarea.getEstado()!=null) {
			 _tarea.setNombre(tarea.getNombre());}
			 return new ResponseEntity<>(repository.save(_tarea), HttpStatus.OK);
			 } else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 }
			 }
	
	//BORRAR UNA TAREA
	
	@DeleteMapping("/borrarTarea/{id}")
	public void deleteTarea(@PathVariable(value="id") int id) {  //throws tarea not found exception si no encuentra la tarea a borrar
		repository.deleteById(id);	
		System.out.println("Se borro la tarea "+id);
	}
	
	

}
