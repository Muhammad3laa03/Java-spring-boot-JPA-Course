package com.MuhammadDev.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Table(name = "Section")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Section extends BaseEntity {


    @Column(name="name" , nullable = false ,unique = true)
    private String name;

    private int SectionOrder ;
    /*
    when we create course we have course, but we create section
    we have the foreign key   course_id
     */
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
/*
one section can be studied in many lectures
 */

    @OneToMany(mappedBy = "section")
    private List<Lecture>lectures;
}
