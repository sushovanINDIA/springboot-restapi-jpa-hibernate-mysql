package com.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.ApplicationModel;
import com.application.service.ApplicationService;

@RestController
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	
	@PostMapping("/employees")
	public ApplicationModel createEmployee(@Valid @RequestBody ApplicationModel applicationModel){
		return applicationService.saveData(applicationModel);
	}
	
	@GetMapping("/employees")
	public List<ApplicationModel> getEmployee(){
		return applicationService.getData();
	}
	
//	@GetMapping("/employees/{id}")
//	public ResponseEntity<ApplicationModel> getPerticular(Integer id){
//		ApplicationModel applicationModel = applicationService.getOneData(id);
//		return ResponseEntity.ok().body(applicationModel);
//	}
	
	@GetMapping("/employees/{id}")
	public ApplicationModel getPerticular(Integer id) {
		
		//ApplicationModel applicationModel = applicationService.getOneData(id);
		//return applicationModel;
		return applicationService.getOneData(id);
		
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<ApplicationModel> deleteEmployee(@PathVariable(value="id") Integer id){
		
		ApplicationModel app=applicationService.getOneData(id);
		if(app==null) {
			return ResponseEntity.notFound().build();
		}
		applicationService.deleteData(app);;
		
		return ResponseEntity.ok().build();
		
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<ApplicationModel> updateEmployee(@PathVariable (value="id") Integer id,@Valid @RequestBody ApplicationModel applicationModel){
		
		ApplicationModel app=applicationService.getOneData(id);
		if(app==null) {
			return ResponseEntity.notFound().build();
		}
		
		app.setName(applicationModel.getName());
		app.setAddress(applicationModel.getAddress());
		
		
		ApplicationModel updateEmployee=applicationService.saveData(app);
		return ResponseEntity.ok().body(updateEmployee);
	}
	
	
}