package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.model.ApplicationModel;

public interface ApplicationRepository extends JpaRepository<ApplicationModel, Integer> {

}
