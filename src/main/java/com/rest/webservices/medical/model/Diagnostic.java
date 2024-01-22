package com.rest.webservices.medical.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Diagnostic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDiagnostic;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false, foreignKey = @ForeignKey(name = "FK_DIAGNOSTIC_PATIENT"))
    @JsonIgnoreProperties("diagnostics")
    private Patient patient;

    @Column(nullable = false, length = 50)
    private String typeTreatment;

    @Column(nullable = false, length = 100)
    private String treatment;

    @Column(nullable = false, length = 100)
    private String complication;
}
