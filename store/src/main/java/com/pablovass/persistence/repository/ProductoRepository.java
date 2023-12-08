package com.pablovass.persistence.repository;

import com.pablovass.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends CrudRepository<Producto,Integer> {
    @Query(value = "SELECT * FROM productos WHERE id_categoria= ? ", nativeQuery = true) //query nativa
    List<Producto>findByIdCategoria(int idCategoria); //query method

    List<Producto>findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock,boolean estado);
}
