package com.MuhammadDev.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;



@EqualsAndHashCode(callSuper = true)
@Table(name = "Author")
@Entity



@NamedQuery(
        name = "Author.findByAgeLessThanOrEquals",
        query = "select a from Author a where a.age >= :age"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
// Extends the attributes from 'BaseEntity'
public class Author extends BaseEntity {
    @Id
    @GeneratedValue
    @Column( name = "id" , unique = true ,updatable = false ,nullable = false )
    private Integer id;
    @Column( name = "first_name" )
    private String firstName;
    @Column( name = "last_name" )
    private String lastName;
    @Column( name = "email" , unique = true )
    private String email;
    @Column( name = "age")
    private int age;
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "last_modified", insertable = false)
    private LocalDateTime lastModified;

/*
 Authors in relation Many to Many with Course
     many Authors can present many courses
     Author is the inverse entity
 */
    @ManyToMany(mappedBy ="authors")
    private List<Course>courses;


}
