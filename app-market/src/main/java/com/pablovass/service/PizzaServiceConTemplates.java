package com.pablovass.service;

import com.pablovass.persistence.entity.PizzaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceConTemplates {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PizzaServiceConTemplates(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public List<PizzaEntity> getAll(){
        return this.jdbcTemplate.query("SELECT * FROM pizza",new BeanPropertyRowMapper<>(PizzaEntity.class));
    }
}
