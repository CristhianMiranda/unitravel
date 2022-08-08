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
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Habitacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 50)
    private int numero;
    @Positive
    @Column(nullable = false)
    private String precio;

    @Positive
    @Column(length = 50,nullable = false)
    private int capacidad;

    @ManyToMany(mappedBy="habitaciones")
    private List<Caracteristica> caracteristicas;

    @ManyToMany(mappedBy="habitaciones")
    private List<Cama> camas;

    @OneToMany(mappedBy="habitacion")
    private List<Foto> fotos;

    @OneToMany(mappedBy="habitacion")
    private List<ReservaHabitacion> reservaHabitaciones;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Hotel hotel;
    public Habitacion(short numero, String precio, short capacidad) {
        this.numero = numero;
        this.precio = precio;
        this.capacidad = capacidad;
    }


}
