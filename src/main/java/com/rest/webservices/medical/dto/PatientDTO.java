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
public class PatientDTO {

    private Integer idPatient;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String dni;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String telephone;

    @NotNull
    private short nroRooms;

    @NotNull
    @JsonIgnoreProperties("patient")
    private List<DiagnosticDTO> diagnostics;

    @NotNull
    @JsonIgnoreProperties("patients")
    List<DoctorDTO> doctors;
}
