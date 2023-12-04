package com.pablovass.persistence.repository;

import com.pablovass.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {
}
