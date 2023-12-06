package com.pablovass.service;

import com.pablovass.persistence.entity.OrderEntity;
import com.pablovass.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private  static  final String DELIVERY="D";
    private  static  final String CARRYOUT="C";
    private  static  final String ON_SIDE="S";

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAll() {
        List<OrderEntity>orders=this.orderRepository.findAll();
        orders.forEach(o-> System.out.println(o.getCustomer().getName()));
        return orders;
    }
    public List<OrderEntity>getTodayOrder(){
        LocalDateTime today=LocalDate.now().atTime(0,0,0);
       // LocalDateTime today=LocalDateTime.now().toLocalDate().atTime(0, 0);
       // LocalDateTime today=LocalDateTime.now().withHour(0).withMinute(0);
        //LocalDateTime today = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0));
        return this.orderRepository.findAllByDateAfter(today);
    }
    public List<OrderEntity>getOutsideOrders(){
        List<String> methods= Arrays.asList(DELIVERY,CARRYOUT);
        return this.orderRepository.findAllByMethodIn(methods);
    }
}
