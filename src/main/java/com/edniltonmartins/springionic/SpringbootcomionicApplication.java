package com.edniltonmartins.springionic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edniltonmartins.springionic.domain.Categoria;
import com.edniltonmartins.springionic.domain.Cidade;
import com.edniltonmartins.springionic.domain.Cliente;
import com.edniltonmartins.springionic.domain.Endereco;
import com.edniltonmartins.springionic.domain.Estado;
import com.edniltonmartins.springionic.domain.Produto;
import com.edniltonmartins.springionic.domain.emuns.TipoCliente;
import com.edniltonmartins.springionic.repositories.CategoriaRepository;
import com.edniltonmartins.springionic.repositories.CidadeRepository;
import com.edniltonmartins.springionic.repositories.ClienteRepository;
import com.edniltonmartins.springionic.repositories.EnderecoRepository;
import com.edniltonmartins.springionic.repositories.EstadoRepository;
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
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired 
	private EnderecoRepository enderecoRepository;

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
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Minas Gerais");
		
		Cidade cidade1 = new Cidade(null, "Uberlândia", est2);
		Cidade cidade2 = new Cidade(null, "São Paulo", est1);
		Cidade cidade3 = new Cidade(null, "Campinas", est1);
		
		est1.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		est2.getCidades().addAll(Arrays.asList(cidade1));
		
		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(cidade1,cidade2,cidade3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, cidade2);
		Endereco endereco2 = new Endereco(null, "Avenida Matos", "105","Sala 800", "Centro", "38777012", cli1, cidade1);
		
		cli1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
		cli1.getTelefones().addAll(Arrays.asList("21292882772","11437892478"));
		clienteRepository.save(cli1);
		
		enderecoRepository.save(Arrays.asList(endereco1,endereco2));
	}
}
