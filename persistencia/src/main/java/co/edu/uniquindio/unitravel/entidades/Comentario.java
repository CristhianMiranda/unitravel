package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(length = 6)
    private int codigo;

    @Column(nullable = false,length = 220)
    private String comentario;

    @Min(0)
    @Max(5)
    @Column(nullable = false)
    private double calificacion;
/*
    @JoinColumn(name = "cedulaCliente")
    @ManyToOne
    private Cliente cliente;
*/

    @JoinColumn(name = "cedulaUsuario")
    @ManyToOne
    private Usuario usuario;



    @JoinColumn(name = "codigoHotel",nullable = false)
    @ManyToOne
    private Hotel hotel;
    /*
    @OneToMany(mappedBy="comentario")
    private List<Hotel> hoteles;
    */
    @Column(nullable = false)
    private LocalDate fechaCalificacion;


    public Comentario(String comentario, double calificacion/*, LocalDateTime fechaCalificacion*/) {
        this.comentario = comentario;
        this.calificacion = calificacion;
       // this.fechaCalificacion = fechaCalificacion;
    }

}
