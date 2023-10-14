/*
1. Crie uma aplicação que use um banco relacional contendo uma tabela de produtos, com sua respectiva Classe (Entidade) Java. Cada produto deve ter um id, código, descrição, preço, quantidade em estoque e data da última entrada. 
 */
package com.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    private Integer id;
    private String code;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private String lastEntryDate;
    
}
