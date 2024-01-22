package com.rest.webservices.medical.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDoctor;

    @ManyToOne
    @JoinColumn(name = "id_hospital")
    @JsonIgnoreProperties("doctors")
    private Hospital hospital;

    @Column(nullable = false, length = 10, unique = true)
    private String dni;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 80)
    private String speciality;

    @Column(nullable = false, length = 10)
    private String telephone;

    @ManyToMany(mappedBy = "doctors")
    @JsonIgnoreProperties("doctors")
    private List<Patient> patients;
}
