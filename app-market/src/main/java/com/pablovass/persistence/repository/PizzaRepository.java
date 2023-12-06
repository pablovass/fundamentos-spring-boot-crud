package com.pablovass.persistence.repository;

import com.pablovass.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);
    PizzaEntity findTopByAvailableTrueAndNameIgnoreCase(String name); // (lo mismo) PizzaEntity findFirstByAvailableTrueAndNameIgnoreCase(String name);
    Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);

    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);

    List<PizzaEntity>findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description); // SON FORMAS PARECIDAS List<PizzaEntity>queryAllBy   List<PizzaEntity>searchAllBy List<PizzaEntity>getAllBy

    List<PizzaEntity>findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
    int countByVeganTrue();

}
