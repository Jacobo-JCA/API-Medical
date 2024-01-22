package com.rest.webservices.medical.dto;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiagnosticDTO {

    private Integer idDiagnostic;

    // Se debe ingresar porque es una llave foranea, obligatorio
    @NotNull
    @JsonIgnoreProperties("diagnostics")
    private PatientDTO patient;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    private String typeTreatment;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    private String treatment;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    private String complication;
}
