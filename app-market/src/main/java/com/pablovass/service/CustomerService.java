package com.pablovass.service;

import com.pablovass.persistence.entity.CustomerEntity;
import com.pablovass.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity findbyPhone(String phone) {
        return this.customerRepository.findByPhone(phone);
    }
}

