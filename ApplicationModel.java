package com.application.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="tbl_employee")
@EntityListeners(AuditingEntityListener.class)
public class ApplicationModel {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id", nullable =true)
	Integer id;
	String name;
	String address;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public ApplicationModel(Integer id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public ApplicationModel() {
		
	}
	
}
