package com.virtukch.dongiveupbe.essential_product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class EssentialProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long essentialProductId;

    private String essentialProductName;

    private Long essentialProductHp;

    private String essentialProductDescription;

    public EssentialProduct(String essentialProductName, Long essentialProductHp, String essentialProductDescription) {
        this.essentialProductName = essentialProductName;
        this.essentialProductHp = essentialProductHp;
        this.essentialProductDescription = essentialProductDescription;
    }
}
