package com.edniltonmartins.springionic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edniltonmartins.springionic.domain.Produto;;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}