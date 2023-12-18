package com.pablovass.controller;

import com.pablovass.persistence.entity.CustomerEntity;
import com.pablovass.persistence.entity.OrderEntity;
import com.pablovass.service.CustomerService;
import com.pablovass.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerCotroller {
    private final CustomerService customerService;
    private  final OrderService orderService;

    public CustomerCotroller(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<CustomerEntity>getByPhone(@PathVariable String phone){
        return ResponseEntity.ok(this.customerService.findbyPhone(phone));
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<List<OrderEntity>>getCustomerOrders(@PathVariable String id){
        return ResponseEntity.ok(this.orderService.getCustomerOrders(id));
    }
}
