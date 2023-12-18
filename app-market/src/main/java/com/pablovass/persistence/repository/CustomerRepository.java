package com.pablovass.persistence.repository;

import com.pablovass.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
    @Query(value = "SELECT c FROM CustomerEntity c WHERE c.phoneNumber= :phone")
    CustomerEntity findByPhone(@Param("phone") String phone);
}
