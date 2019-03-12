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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeicus.Backend.exception.TareaNotFoundException;
import com.codeicus.Backend.model.Log;
import com.codeicus.Backend.model.Tarea;
import com.codeicus.Backend.repo.LogRepository;
import com.codeicus.Backend.repo.TareaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/codeicus")
public class TareaController {

	@Autowired
	private TareaRepository repository;

	@Autowired
	private LogRepository repoLog;

	// LISTAR TODAS LAS TAREAS
	@GetMapping("/listarTareas")
	public List<Tarea> listarTareas() {
		return repository.findAll();
	}

	// OBTENER UNA TAREA
	@GetMapping("/getTarea/{id}")
	public Tarea detalleTarea(@PathVariable(value = "id") int id) throws TareaNotFoundException {
		final Optional<Tarea> _tarea = repository.findById(id);
		if (!_tarea.isPresent()) {
			throw new TareaNotFoundException("No se encontro");

		}
		return _tarea.get();

	}

	// CREAR NUEVA TAREA
	@PostMapping("/crearTarea")
	public Tarea crearTarea(@RequestBody Tarea tarea) {
		Log log = repoLog.save(new Log("Se creo la tarea con nombre: " + tarea.getNombre()));
		return repository.save(tarea);
	}

	// MODIFICAR UNA TAREA

	@PutMapping("/modificarTarea/{id}")
	public ResponseEntity<Tarea> modificarTarea(@PathVariable int id, @Valid @RequestBody Tarea tarea) { 
																											
		Optional<Tarea> ta = repository.findById(id);
		if (ta.isPresent()) {
			Tarea _tarea = ta.get();
			if (tarea.getDetalle() != null) {
				_tarea.setDetalle(tarea.getDetalle());
			}
			if (tarea.getEstado() != null) {
				_tarea.setEstado(tarea.getEstado());
			}
			if (tarea.getEstado() != null) {
				_tarea.setNombre(tarea.getNombre());
			}
			Log log = repoLog.save(new Log("Se modifico la tarea con nombre: " + tarea.getNombre()));
			return new ResponseEntity<>(repository.save(_tarea), HttpStatus.OK);
		} else {
			Log log = repoLog.save(new Log("No se pudo modificar la tarea con nombre: " + tarea.getNombre()));
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// BORRAR UNA TAREA
	@DeleteMapping("/borrarTarea/{id}")
	public void deleteTarea(@PathVariable(value = "id") int id) throws TareaNotFoundException {
		Optional<Tarea> ta = repository.findById(id);
		if (ta.isPresent()) {
			Tarea _tarea = ta.get();
			Log log = repoLog.save(new Log("Se borro la tarea con nombre: " + _tarea.getNombre()));
			repository.deleteById(id);
		} else {
			Log log = repoLog.save(new Log("Se quiso borrar una tarea pero no se encontro la misma"));
			throw new TareaNotFoundException("No se encontro la tarea a borrar");
		}
	}

}
