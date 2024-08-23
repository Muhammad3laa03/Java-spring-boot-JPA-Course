package com.MuhammadDev.jpa.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Table(name = "Lecture")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Lecture extends BaseEntity {



    @Column(name="lecture_name" , nullable = false ,unique = true)
    private String lectureName;


    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Section section;

    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resources resources;

}
