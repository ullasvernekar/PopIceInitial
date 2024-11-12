package com.Project.ProductMapping.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private long quantity;

    private long productPrice;

    @ManyToOne(fetch =FetchType.EAGER,cascade = CascadeType.ALL)

    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private FoodMenu foodMenu;

}
