package com.pablovass.service;

import com.pablovass.persistence.entity.PizzaEntity;
import com.pablovass.persistence.repository.PizzaPagSortRepository;
import com.pablovass.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private  final PizzaPagSortRepository pizzaPagSortRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository, PizzaPagSortRepository pizzaPagSortRepository) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaPagSortRepository = pizzaPagSortRepository;
    }



   // public List<PizzaEntity> getAll() {
   //     return this.pizzaRepository.findAll();
   // }

    public Page<PizzaEntity> getAll(int page, int elements) {
        Pageable pageRequest= PageRequest.of(page,elements);
        return this.pizzaPagSortRepository.findAll(pageRequest);
    }
    public PizzaEntity get(int idPizza) {
        return this.pizzaRepository.findById(idPizza).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizza) {
        return this.pizzaRepository.save(pizza);
    }

    public boolean exists(int idPizza) {
        return this.pizzaRepository.existsById(idPizza);
    }

    public void delete(int idPizza) {
        this.pizzaRepository.deleteById(idPizza);
    }

    public List<PizzaEntity> getAvailable() {
        this.pizzaRepository.countByVeganTrue();
        return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }

   // public PizzaEntity getByName(String name) {
   //     return this.pizzaRepository.findAllByAvailableTrueAndNameIgnoreCase(name);
   // }
   public PizzaEntity getByName(String name) {
    //   return this.pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElse(null);
       return this.pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElseThrow(()->new RuntimeException("la pizza no existe"));
   }

    public List<PizzaEntity> getWith(String ingredient) {
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
    }
    public List<PizzaEntity> getCheaperst(Double price) {
        return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }
    public List<PizzaEntity> getWithOut(String ingredient) {
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
    }
}
