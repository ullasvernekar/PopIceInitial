package com.Project.ProductMapping.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClubInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;


    private long quantity;


    private long type;


    @OneToOne(cascade = CascadeType.ALL  )
    @JoinColumn
    @JsonManagedReference("madhu")
    private Product product;
}
