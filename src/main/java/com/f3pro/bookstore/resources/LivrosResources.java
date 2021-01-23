package com.f3pro.bookstore.resources;

import com.f3pro.bookstore.dtos.LIvroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.f3pro.bookstore.domain.Livro;
import com.f3pro.bookstore.service.LivroService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<List<LIvroDTO>> findAll(@RequestParam(value = "categoria",defaultValue = "0") Integer id_cat) {
        List<Livro> list = livroService.findAll(id_cat);
        List<LIvroDTO> lIvroDTOS = list.stream().map(obj -> new LIvroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(lIvroDTOS);
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro obj) {
        obj = livroService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
