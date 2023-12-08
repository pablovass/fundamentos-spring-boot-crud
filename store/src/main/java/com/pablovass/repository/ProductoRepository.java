package com.pablovass.repository;

import com.pablovass.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductoRepository extends CrudRepository<Producto,Integer> {
    @Query(value = "SELECT * FROM productos WHERE id_categoria= ? ", nativeQuery = true) //query nativa
    List<Producto>findByIdCategoria(int idCategoria); //query method

    List<Producto>findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock,boolean estado);
}
