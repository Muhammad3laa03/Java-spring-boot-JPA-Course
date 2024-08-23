package com.MuhammadDev.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Table(name = "Course")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Course extends BaseEntity {



    @Column(name="title" , nullable = false ,unique = true)
    private String title;
    @Column(name="Description" , nullable = false )
    private String Description;

    /*
 Authors in relation Many to Many with Course
     many Authors can present many courses
     Course  is the owner entity
     Creating table "authors_courses" with "course_id" and "author_id"
 */
    @ManyToMany
    @JoinTable(name = "authors_courses",
            joinColumns = { @JoinColumn(name ="course_id") },
            inverseJoinColumns ={@JoinColumn(name="author_id")}
    )

    private List<Author>authors;
/*
when we create course we have course, but we create section
we have the foreign key   course_id
 */
    @OneToMany(mappedBy ="course")
    private List<Section>sections;



}
