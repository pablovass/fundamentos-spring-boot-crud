package com.pablovass.persistence.repository;

import com.pablovass.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);
    List<PizzaEntity>findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description); // SON FORMAS PARECIDAS List<PizzaEntity>queryAllBy   List<PizzaEntity>searchAllBy List<PizzaEntity>getAllBy

    List<PizzaEntity>findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);

}
