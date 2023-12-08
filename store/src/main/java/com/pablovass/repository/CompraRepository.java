package com.pablovass.repository;

import com.pablovass.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraRepository extends CrudRepository<Compra, Integer> {
        Optional<List<Compra>> findByIdCliente(String idCliente);
}
