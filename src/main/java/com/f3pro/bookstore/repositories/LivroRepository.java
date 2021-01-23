package com.f3pro.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.f3pro.bookstore.domain.Livro;

import java.util.List;

@Repository
public interface LivroRepository  extends JpaRepository<Livro, Integer>{

    //query JPQL personalizada
    @Query("SELECT obj FROM Livro obj WHERE obj.categoria.id =:id_cat order by titulo")
    List<Livro> findAllByCategoria( @Param(value = "id_cat") Integer id_cat);
}
