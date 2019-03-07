package com.codeicus.Backend.controller;


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

import com.codeicus.Backend.model.Tarea;
import com.codeicus.Backend.repo.TareaRepository;


@RestController
@RequestMapping ("/codeicus")
public class TareaController {
	
	@Autowired
	private TareaRepository repository;
	
	/*@RequestMapping ("/tarea")
	public String obtnRta() {
		return "Funciona";
	}*/
	
	
	//LISTAR TODAS LAS TAREAS
	
	@GetMapping("/listarTareas")
    public List<Tarea> listarTareas() {
        return repository.findAll();
    }
	
	//OBTENER DETALLE DE UNA TAREA
	
	@GetMapping ("/tareas/{id}")
	public Optional<Tarea> detalleTarea(@PathVariable(value = "id") int id) {
		return repository.findById(id);
	}
	/*public ResponseEntity<Tarea> detalleTarea(@PathVariable("id") int id) {
		Optional<Tarea> ta= repository.findById(id);
		if (ta.isPresent()) {
			Tarea _tarea= ta.get();
			_tarea.getNombre();
			_tarea.getDetalle();
			_tarea.getEstado();
		return new ResponseEntity<>(HttpStatus.OK);
	 } else {
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }}*/
	
	
	//CREAR NUEVA TAREA
	
	@PostMapping ("/crearTarea")
	public Tarea crearTarea(@RequestBody Tarea tarea) {
		return repository.save(tarea);	
	}
	
	//MODIFICAR UNA TAREA
	
	@PutMapping ("/modificarTarea/{id}")
	/*public Tarea modificarTarea(@PathVariable(value = "id") int id, @Valid @RequestBody Tarea tarea) {
		
		Optional<Tarea> _tarea = repository.findById(id);
		_tarea.setDetalle(tarea.getDetalle());
		_tarea.setEstado(tarea.getEstado());
		_tarea.setNombre(tarea.getNombre());
		Tarea _tareaActualizada= repository.save(_tarea);
		return _tareaActualizada;				
	}*/
	public ResponseEntity<Tarea> modificarTarea(@PathVariable int id, @Valid @RequestBody Tarea tarea) {
		Optional<Tarea> ta = repository.findById(id);

		 if (ta.isPresent()) {
			 Tarea _tarea = ta.get();
			 _tarea.setDetalle(tarea.getDetalle());
			 _tarea.setEstado(tarea.getEstado());
			 _tarea.setNombre(tarea.getNombre());
			 return new ResponseEntity<>(repository.save(_tarea), HttpStatus.OK);
			 } else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 }
			 }
	
	//BORRAR UNA TAREA
	
	/*@DeleteMapping(path="/borrarTarea/{id}")
	 public ResponseEntity<?> deleteTarea(@PathVariable("id") int id) {
		 //System.out.println("Borrar tarea con id:  = " + id + "...");
		 //Optional<Tarea> _tarea= repository.findById(id);
		 
		 return repository.findById(id)
			        .map(record -> {
			            repository.deleteById(id);
			            return ResponseEntity.ok().build();
			        }).orElse(ResponseEntity.notFound().build());
		
				 //new ResponseEntity<>("La tarea ha sido borrada", HttpStatus.OK);
		 }*/
	
	@DeleteMapping("/borrarTarea/{id}")
	public void deleteTarea(@PathVariable(value="id") int id) {
		repository.deleteById(id);		
	}
	/*public Map<String, Boolean> deleteTarea(@PathVariable(value = "id") int id){
	  //throws ResourceNotFoundException {
	 Optional<Tarea> repository.findById(id);
	   //.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

	 repository.deleteById(id);
	 Map<String, Boolean> response = new HashMap<>();
	 response.put("deleted", Boolean.TRUE);
	 return response;
	}*/
	

}
