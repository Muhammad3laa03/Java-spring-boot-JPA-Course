package com.MuhammadDev.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


/*
Base entity with some attribute to inherit in the rest of entities
 */






@MappedSuperclass  // note that 'BaseEntity' is super class
@Data  // to generate all getters and setters
@AllArgsConstructor // to generate All Args Constructor getters and setters
@NoArgsConstructor // to generate No Args Constructor getters and setters
@SuperBuilder // build some data
public class BaseEntity {
    @Id
    @GeneratedValue
    @Column( name = "id" , unique = true ,updatable = false ,nullable = false )
    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime LastModifiedAt;
    private String createdBy;
    private String LastModifiedBy;

}
