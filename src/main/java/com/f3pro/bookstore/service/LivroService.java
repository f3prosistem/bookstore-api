package com.f3pro.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.f3pro.bookstore.domain.Livro;
import com.f3pro.bookstore.repositories.LivroRepository;
import com.f3pro.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        Optional<Livro> obj = livroRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Livro não localizado! id: " + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Integer id_cat) {
        categoriaService.findById(id_cat);
        return livroRepository.findAllByCategoria(id_cat);
    }


    public Livro create(Livro obj) {
        obj.setId(null);
        return livroRepository.save(obj);
    }

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateDate(newObj, obj);
		return livroRepository.save(newObj);
		
		
		
	}

	private void updateDate(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
	}
}
