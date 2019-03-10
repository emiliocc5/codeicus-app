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

import com.codeicus.Backend.exception.TareaNotFoundException;
import com.codeicus.Backend.model.Log;
import com.codeicus.Backend.model.Tarea;
import com.codeicus.Backend.repo.LogRepository;
import com.codeicus.Backend.repo.TareaRepository;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping ("/codeicus")
public class TareaController {
	
	@Autowired
	private TareaRepository repository;
	
	@Autowired
	private LogRepository repoLog;
	
	
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
			throw new TareaNotFoundException("No se encontro");
			
		}
		return TareaOptional.get();
				
	}	
	//CREAR NUEVA TAREA
	
	@PostMapping ("/crearTarea")
	public Tarea crearTarea(@RequestBody Tarea tarea) {
		//this.log.setDetalle("Se creo la tarea con id: "+tarea.getId());
		Log log=repoLog.save(new Log("Se creo la tarea con id: "+tarea.getNombre()));
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
			 /*this.log.setDetalle("Se modifico la tarea: "+_tarea.getId());
			 repoLog.save(log);*/
			 return new ResponseEntity<>(repository.save(_tarea), HttpStatus.OK);
			 } else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 }
			 }
	
	//BORRAR UNA TAREA	
	@DeleteMapping("/borrarTarea/{id}")
	public void deleteTarea(@PathVariable(value="id") int id) throws TareaNotFoundException {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			/*this.log.setDetalle("Se borro la tarea "+id);
			this.repoLog.save(log);*/
		}else {
			/*this.log.setDetalle("No se encontro la tarea " +id+ " para borrar");
			this.repoLog.save(log);*/
			throw new TareaNotFoundException("No se encontro la tarea a borrar");
		}
	}

	
	
	

}
