package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caracteristica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 5)
    private String codigo;


    @Column(nullable = false,length = 50)
    private String nombre;

    @ManyToMany
    private List<Hotel> hoteles;

    @ManyToMany
    private List<Habitacion> habitaciones;

    public Caracteristica(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

}
