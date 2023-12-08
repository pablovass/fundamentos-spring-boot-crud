package com.pablovass.persistence.entity;

import com.pablovass.persistence.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

public class ProductoClassRepository {
    private ProductoRepository productoRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
}
