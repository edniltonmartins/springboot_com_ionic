package com.edniltonmartins.springionic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edniltonmartins.springionic.domain.Categoria;
import com.edniltonmartins.springionic.repositories.CategoriaRepository;

@SpringBootApplication
public class SpringbootcomionicApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcomionicApplication.class, args);
	}
	
	@Autowired
	private CategoriaRepository repository;

	@Override
	public void run(String... arg0) throws Exception {
		Categoria categoria1 = new Categoria(null,"Informática");
		Categoria categoria2 = new Categoria(null,"Escritório");
		
		repository.save(Arrays.asList(categoria1, categoria2));
	}
}
