package com.pablovass.service;

import com.pablovass.persistence.dto.RandomOrderDto;
import com.pablovass.persistence.entity.OrderEntity;
import com.pablovass.persistence.repository.OrderRepository;
import com.pablovass.projection.OrderSummary;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SIDE = "S";

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAll() {
        List<OrderEntity> orders = this.orderRepository.findAll();
        orders.forEach(o -> System.out.println(o.getCustomer().getName()));
        return orders;
    }

    public List<OrderEntity> getTodayOrder() {
        LocalDateTime today = LocalDate.now().atTime(0, 0, 0);
        // LocalDateTime today=LocalDateTime.now().toLocalDate().atTime(0, 0);
        // LocalDateTime today=LocalDateTime.now().withHour(0).withMinute(0);
        //LocalDateTime today = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0));
        return this.orderRepository.findAllByDateAfter(today);
    }

    public List<OrderEntity> getOutsideOrders() {
        List<String> methods = Arrays.asList(DELIVERY, CARRYOUT);
        return this.orderRepository.findAllByMethodIn(methods);
    }

    @Secured("ROLE_ADMIN") // SEGURIZAMOS EL METODO CON MERMISOS DE ADMINISTRADOR
    public List<OrderEntity> getCustomerOrders(String idCustomer) {
        return this.orderRepository.findCustomerOrders(idCustomer);
    }

    public OrderSummary getSummary(int orderId) {
        return this.orderRepository.findSummary(orderId);
    }

    @Transactional
    public boolean saveRandomOrder(RandomOrderDto randomOrderDto) {
        return this.orderRepository.saveRamdomOrder(randomOrderDto.getIdCustomer(), randomOrderDto.getMethod());
    }
}
