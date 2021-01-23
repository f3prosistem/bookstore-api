package com.f3pro.bookstore.dtos;

import com.f3pro.bookstore.domain.Livro;

import java.io.Serializable;

public class LIvroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;


    public LIvroDTO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public LIvroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();


    }

}

