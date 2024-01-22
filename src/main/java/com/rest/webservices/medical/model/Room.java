package com.rest.webservices.medical.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idRoom;

    @ManyToOne
    @JoinColumn(name = "id_hospital", nullable = false, foreignKey = @ForeignKey(name = "FK_ROOM_HOSPITAL"))
    private Hospital hospital;

    @Column(nullable = false, length = 50)
    private String nameRoom;

    @Column(nullable = false)
    private short nroBeds;
}
