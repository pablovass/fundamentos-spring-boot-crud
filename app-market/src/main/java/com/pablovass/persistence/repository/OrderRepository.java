package com.pablovass.persistence.repository;

import com.pablovass.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findAllByDateAfter(LocalDateTime today);// es el equivalente a where date > ?

    List<OrderEntity> findAllByDateGreaterThanEqual(LocalDateTime date); // es el equivalente a where date >=?

    List<OrderEntity> findAllByMethodIn(List<String> method);

    // sql nativo tienen nativeQuery = true de lo contrario son jpquery
    @Query(value = "SELECT * FROM pizza_order WHERE id_customer = :id", nativeQuery = true)
    List<OrderEntity> findCustomerOrders(@Param("id") String idCustomer);

}
