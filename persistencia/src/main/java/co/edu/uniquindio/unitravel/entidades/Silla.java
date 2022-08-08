package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Silla implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 2)
    private String codigo;
    @Column(length = 2)
    private String posicion;

    @Positive
    private float precio;

    @ManyToOne
    @JoinColumn(name = "codigoVuelo",nullable = false)
    private Vuelo vuelo;

    @OneToMany(mappedBy="silla")
    private List<ReservaSilla> reservaSillas;

    public Silla(String codigo, String posicion, float precio) {
        this.codigo = codigo;
        this.posicion = posicion;
        this.precio = precio;
    }

   }
