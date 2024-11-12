package com.Project.ProductMapping.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FoodMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)

    private long id;

    private String name;

    private String description;

    private  long  totalPrice;


@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JoinColumn
    private List<FoodProduct> foodProduct;

}
