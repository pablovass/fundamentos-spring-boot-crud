package com.pablovass.persistence.repository;

import com.pablovass.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto,Integer> {
}
