package com.pablovass.entity;

import com.pablovass.domain.Product;
import com.pablovass.mapper.ProductMapper;
import com.pablovass.repository.ProductRepository;
import com.pablovass.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoClassRepository implements ProductRepository {
    private ProductoRepository productoRepository;
    private ProductMapper mapper;

    @Autowired
    public ProductoClassRepository(ProductoRepository productoRepository, ProductMapper mapper) {
        this.productoRepository = productoRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods)); // como no tengo ningun mapeador que devuelva un lista de obcionales. hago a los productos un map.
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public void delete(int idProducto) {
        productoRepository.deleteById(idProducto);
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoRepository.save(producto));
    }

    /**
     * LOS SIGUIENTES METODOS NO SE VAN A USAR ESTAN DE REFERENCIA
     */

    public List<Producto> getByCategoria(int idCategoria) {
        return productoRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(int idProducto) {
        return productoRepository.findById(idProducto);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

}
