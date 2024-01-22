package com.rest.webservices.medical.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class RoomDTO {

    private Integer idRoom;

    @JsonBackReference
    private HospitalDTO hospital;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 40)
    private String nameRoom;

    @NotNull
    private short nroBeds;
}
