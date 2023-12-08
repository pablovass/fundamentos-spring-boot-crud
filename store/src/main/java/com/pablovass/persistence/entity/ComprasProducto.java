package com.pablovass.persistence.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "compras_productos")
@Getter
@Setter
@NoArgsConstructor
public class ComprasProducto {
    @ManyToOne
    @JoinColumn(name = "id_compra",insertable = false,updatable = false)
    private  Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false,updatable = false)
    private  Producto producto;

    @EmbeddedId
    private ComprasProductoPK id;

    private Integer cantidad;
    private Double total;
    private Boolean estado;
}
