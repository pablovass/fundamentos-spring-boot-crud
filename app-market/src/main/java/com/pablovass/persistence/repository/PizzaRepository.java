package com.pablovass.persistence.repository;

import com.pablovass.persistence.dto.UpdatePizzaPriceDto;
import com.pablovass.persistence.entity.PizzaEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();

    PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);

    PizzaEntity findTopByAvailableTrueAndNameIgnoreCase(String name); // (lo mismo) PizzaEntity findFirstByAvailableTrueAndNameIgnoreCase(String name);

    Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);

    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);

    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description); // SON FORMAS PARECIDAS List<PizzaEntity>queryAllBy   List<PizzaEntity>searchAllBy List<PizzaEntity>getAllBy

    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);

    int countByVeganTrue();

    /**
     * LO COMENTADO FUNCIONA
     */
    // @Query(value = "UPDATE pizza" +
    //         "SET price= :newPrice" +
    //         "WHERE id_pizza= :idPizza", nativeQuery = true)
    //void updatePrice(@Param("idPizza") int idPizza, @Param("newPrice") double newPrice);

    /**
     * ESTAMOS USANDO PARAMETROS EN NUESTRAS CONSUTAS - otra forma diferente pero da el mismo resultado que la de arriba
     */

    @Modifying
    @Query(value =
            "UPDATE pizza " +
                    "SET price = :#{#newPizzaPrice.newPrice} " +
                    "WHERE id_pizza= :#{#newPizzaPrice.pizzaId} ", nativeQuery = true)
    void updatePrice(@Param("newPizzaPrice") UpdatePizzaPriceDto newPizzaPrice);


}
