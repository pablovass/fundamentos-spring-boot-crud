package com.pablovass.persistence.entity;

import com.pablovass.persistence.repository.ProductoRepository;

import java.util.List;

public class ProductoClassRepository {
    private ProductoRepository productoRepository;

    public List<Producto>getAll(){
        return (List<Producto>) productoRepository.findAll();
    }
}
