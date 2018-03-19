package com.edniltonmartins.springionic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edniltonmartins.springionic.domain.Categoria;
import com.edniltonmartins.springionic.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		Categoria categoria = categoriaRepository.findOne(id);
		return categoria;
	}
}
