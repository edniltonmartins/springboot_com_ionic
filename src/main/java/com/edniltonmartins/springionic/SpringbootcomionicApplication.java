package com.edniltonmartins.springionic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edniltonmartins.springionic.domain.Categoria;
import com.edniltonmartins.springionic.domain.Produto;
import com.edniltonmartins.springionic.repositories.CategoriaRepository;
import com.edniltonmartins.springionic.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringbootcomionicApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcomionicApplication.class, args);
	}
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void run(String... arg0) throws Exception {
		Categoria categoria1 = new Categoria(null,"Informática");
		Categoria categoria2 = new Categoria(null,"Escritório");
		
		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 90.00);
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto1));
		
		produto1.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto2.getCategorias().addAll(Arrays.asList(categoria1));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		
		categoriaRepository.save(Arrays.asList(categoria1, categoria2));
		produtoRepository.save(Arrays.asList(produto1, produto2, produto3));
		
	}
}
