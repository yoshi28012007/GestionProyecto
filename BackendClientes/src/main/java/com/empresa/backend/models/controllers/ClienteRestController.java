package com.empresa.backend.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.empresa.backend.models.entity.Cliente;
import com.empresa.backend.models.service.IClienteService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	 @Autowired
	 private IClienteService clienteService;
	 
	@GetMapping("/cliente")
	public List<Cliente> index(){
		return clienteService.findAll();
	}
}
