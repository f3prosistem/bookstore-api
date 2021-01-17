package com.f3pro.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f3pro.bookstore.domain.Categoria;

@Repository
public interface LivroRepository  extends JpaRepository<Categoria, Integer>{

}
