package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Reserva implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(length = 10)
    @ToString.Include
    private int codigo;

    @Column(nullable = false)
    @ToString.Include
    private LocalDate fechaReserva;

    @FutureOrPresent
    @Column(nullable = false)
    @ToString.Include
    private LocalDate fechaInicio;
    @Future
    @Column(nullable = false)
    @ToString.Include
    private LocalDate fechaFin;

    @Positive
    @ToString.Include
    private float precioTotal;
    @ToString.Include
    private String estado;

    @ToString.Include
    private short cantidadPersonas;

    @OneToMany(mappedBy="reserva")
    private List<ReservaSilla> reservaSillas;

    @OneToMany(mappedBy="reserva")
    private List<ReservaHabitacion> reservaHabitaciones;


/*
    @ManyToOne
    @JoinColumn(name = "cedulaCliente",nullable = false)
    private Cliente cliente;



*/



    @ManyToOne
    @JoinColumn(name = "cedulaUsuario",nullable = false)
    private Usuario usuario;







    public Reserva(int codigo, LocalDate fechaReserva, LocalDate fechaInicio, LocalDate fechaFin, float precioTotal, String estado, short cantidadPersonas) {
        this.codigo = codigo;
        this.fechaReserva = fechaReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = precioTotal;
        this.estado = estado;
        this.cantidadPersonas = cantidadPersonas;
    }

}
