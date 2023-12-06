package com.pablovass.persistence.repository;

import com.pablovass.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findAllByDateAfter(LocalDateTime today);// es el equivalente a where date > ?

    List<OrderEntity> findAllByDateGreaterThanEqual(LocalDateTime date); // es el equivalente a where date >=?
    List<OrderEntity>findAllByMethodIn(List<String>method);



}
