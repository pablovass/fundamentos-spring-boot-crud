package com.pablovass.persistence.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="clientes")
@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    @OneToMany(mappedBy = "cliente")
    private List<Compra>compras;

    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private Long celular;
    private String direccion;

    @Column(name="correo_electronico")
    private String correoElectronico;
}
