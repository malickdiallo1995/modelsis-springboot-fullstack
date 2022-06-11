package com.modelsis.appproducts.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Product Entite class mapped with Table Product in dbProduct database
 * Using Lombok who generated  Constructor without argument and Constructor with all arguments
 * Using Lombok to generate and use design Pattern Builder
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date dateCreated;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Type type;
}
