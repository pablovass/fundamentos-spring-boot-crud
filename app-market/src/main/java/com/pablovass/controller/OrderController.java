package com.pablovass.controller;

import com.pablovass.persistence.entity.OrderEntity;
import com.pablovass.projection.OrderSummary;
import com.pablovass.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAll() {
        return ResponseEntity.ok(this.orderService.getAll());
    }

    @GetMapping("/today")
    public ResponseEntity<List<OrderEntity>>getTodayAfters(){
        return ResponseEntity.ok(this.orderService.getTodayOrder());
    }
    @GetMapping("/outside")
    public ResponseEntity<List<OrderEntity>>getOutsideOrders(){
        return ResponseEntity.ok(this.orderService.getOutsideOrders());
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<List<OrderEntity>>getCustomerOrders(@PathVariable String id){
        return ResponseEntity.ok(this.orderService.getCustomerOrders(id));
    }
    @GetMapping("/summary/{id}")
    public ResponseEntity<OrderSummary>getSummary(@PathVariable int id){
        return ResponseEntity.ok(this.orderService.getSummary(id));
    }
}
