package com.f3pro.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f3pro.bookstore.domain.Categoria;
import com.f3pro.bookstore.domain.Livro;
import com.f3pro.bookstore.repositories.CategoriaRepository;
import com.f3pro.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void intaciaBaseDados() {
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Matematica", "Livros calculos de TI");
		Categoria cat3 = new Categoria(null, "Geografia", "Livros de TI");
		
	
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Matematica analitica", "Robert Martin", "Lorem ipsum", cat2);
		Livro l3 = new Livro(null, "geografia analitica", " Martin", "Lorem ipsum", cat3);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l1,l2,l3));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3 ));
		
	}

}
