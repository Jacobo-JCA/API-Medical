package com.rest.webservices.medical.dto;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorDTO {

    private Integer idDoctor;

    @NotNull
    @JsonIgnoreProperties("doctors")
    private HospitalDTO hospital;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String dni;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 40)
    private String speciality;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String telephone;

    @NotNull
    @JsonIgnoreProperties("doctors")
    private List<PatientDTO> patients;
}
