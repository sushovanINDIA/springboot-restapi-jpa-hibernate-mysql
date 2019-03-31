package com.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.ApplicationModel;
import com.application.repository.ApplicationRepository;

@Service
public class ApplicationService {
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	// To save data
	
	public ApplicationModel saveData(ApplicationModel applicationModel){
		return applicationRepository.save(applicationModel);
	}
	
	//To get all data
	public List<ApplicationModel> getData(){
		return applicationRepository.findAll();
	}
	
	//To get data byId
	public ApplicationModel getOneData(Integer id){
		return applicationRepository.getOne(id);
	}
	
	//To delete data
	public void deleteData(ApplicationModel applicationModel){
		applicationRepository.delete(applicationModel);
	}
}
