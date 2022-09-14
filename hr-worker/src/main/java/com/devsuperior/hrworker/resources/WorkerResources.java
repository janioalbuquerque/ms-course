package com.devsuperior.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.respositories.WorkerRepository;

@RestController
@RequestMapping(value="/workers")
public class WorkerResources {
	
	@Autowired
	private WorkerRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> lista = repository.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Worker> findById(@PathVariable long id){
		Worker worker = repository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
}
