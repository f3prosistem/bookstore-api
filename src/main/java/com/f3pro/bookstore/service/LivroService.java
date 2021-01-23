package com.f3pro.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.f3pro.bookstore.domain.Livro;
import com.f3pro.bookstore.repositories.LivroRepository;
import com.f3pro.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Livro findById(Integer id) {
        Optional<Livro> obj = livroRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Livro não localizado! id: " + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }
}
