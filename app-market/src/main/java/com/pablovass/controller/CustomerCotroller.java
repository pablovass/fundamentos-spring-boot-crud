package com.pablovass.controller;

import com.pablovass.persistence.entity.CustomerEntity;
import com.pablovass.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerCotroller {
    private final CustomerService customerService;

    @Autowired
    public CustomerCotroller(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/phone/{phone}")
    public ResponseEntity<CustomerEntity>getByPhone(@PathVariable String phone){
        return ResponseEntity.ok(this.customerService.findbyPhone(phone));
    }
}
