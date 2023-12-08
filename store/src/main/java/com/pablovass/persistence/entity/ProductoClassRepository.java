package com.pablovass.persistence.entity;

import com.pablovass.persistence.repository.ProductoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
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
    public Optional<Producto>getProducto(int idProducto){
        return productoRepository.findById(idProducto);
    }
    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }
    public void delete(int idProducto){
        productoRepository.deleteById(idProducto);
    }
}
