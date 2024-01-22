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
public class HospitalDTO {

    private Integer idHospital;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 10)
    private String direction;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String telephone;

    @NotNull
    private short nroRooms;

    @NotNull
    @JsonIgnoreProperties("hospital")
    private List<DoctorDTO> doctors;

    @JsonIgnore
    private List<RoomDTO> rooms;
}
