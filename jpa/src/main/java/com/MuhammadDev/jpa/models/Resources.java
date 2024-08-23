package com.MuhammadDev.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;



@Table(name = "Resources")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
/*
adding column "resource_type"  in "Resources" table with values T , V and F for Text , Video and File respectively
 */
//@DiscriminatorColumn(name = "resource_type")
public class Resources  {

    @Id
    @GeneratedValue
    @Column( name = "id" , unique = true ,updatable = false ,nullable = false )
    private Integer id;

    private String name;
    private String url ;
    private double size ;
/*
each lecture has one resource in ant type (text, video, file )
 */
    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

}
