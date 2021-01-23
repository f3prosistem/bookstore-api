package com.f3pro.bookstore.resources;

import com.f3pro.bookstore.dtos.LIvroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f3pro.bookstore.domain.Livro;
import com.f3pro.bookstore.service.LivroService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivrosResources {
    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro obj = livroService.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    @GetMapping
    public ResponseEntity<List<LIvroDTO>> findAll() {
        List<Livro> list = livroService.findAll();
        List<LIvroDTO> lIvroDTOS = list.stream().map(obj -> new LIvroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(lIvroDTOS);
    }

}
