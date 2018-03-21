package com.edniltonmartins.springionic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edniltonmartins.springionic.domain.Cliente;
import com.edniltonmartins.springionic.repositories.ClienteRepository;
import com.edniltonmartins.springionic.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Integer id) {
		Cliente cliente = clienteRepository.findOne(id);
		if (cliente==null) {
			throw new ObjectNotFoundException("Cliente com id: " + id + " não foi encontrado.");
		}
		return cliente;
	}
}
