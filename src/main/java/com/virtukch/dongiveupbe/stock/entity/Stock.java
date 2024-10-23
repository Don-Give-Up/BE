package com.virtukch.dongiveupbe.stock.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stock_id;

    private String stock_name;

    public Stock(String stock_name) {
        this.stock_name = stock_name;
    }
}
