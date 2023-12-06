package com.pablovass.persistence.repository;

import com.pablovass.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PizzaPagSortRepository extends ListPagingAndSortingRepository <PizzaEntity,Integer>{

}
