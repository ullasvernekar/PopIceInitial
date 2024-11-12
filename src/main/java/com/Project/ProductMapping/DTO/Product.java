package com.Project.ProductMapping.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long conversion;
    private long price;
    private long total;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "product")
    @JsonBackReference("madhu")
    @JoinColumn
    private ClubInventory clubInventory;


}