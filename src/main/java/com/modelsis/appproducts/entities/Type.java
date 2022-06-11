package com.modelsis.appproducts.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * ProductType Entite class mapped with Table ProductType in dbProduct database
 * Using Lombok who generated  Constructor without argument and Constructor with all arguments
 * Using Lombok to generate and use design Pattern Builder
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Type implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
     @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
     @JsonIgnore
     private List<Product> productList;
}
