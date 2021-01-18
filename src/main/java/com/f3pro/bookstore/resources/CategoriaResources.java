package com.f3pro.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f3pro.bookstore.domain.Categoria;
import com.f3pro.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

	@Autowired
	private CategoriaService service;

	//localhost:8080/categorias/1
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findByid(@PathVariable Integer id) {
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

}
