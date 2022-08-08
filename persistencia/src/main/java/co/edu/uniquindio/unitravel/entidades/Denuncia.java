package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Denuncia implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(length = 6)
    @EqualsAndHashCode.Include
    private int codigo;
/*
    @Column(nullable = false,length = 220)
    private String motivo;*/
    @Column(nullable = false,length = 220)
    private String mensaje;



    @JoinColumn(name = "cedulaUsuario",nullable = false)
    @ManyToOne
    private Usuario usuario;

    @JoinColumn(name = "codigoHotel",nullable = false)
    @ManyToOne
    private Hotel hotel;


    public Denuncia(String mensaje/*, String motivo*/) {

        this.mensaje = mensaje;
       // this.motivo = motivo;
    }

}
