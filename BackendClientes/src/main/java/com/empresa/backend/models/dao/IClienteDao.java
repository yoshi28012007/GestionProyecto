package com.empresa.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.empresa.backend.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
	

}
