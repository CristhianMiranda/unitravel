package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PuntosUsuario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;

    @ManyToOne
    @JoinColumn(name = "cedulaUsuario",unique = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "codigoPuntos",unique = false)
    private Puntos puntos;

/*
    @ManyToOne
    @JoinColumn(name = "codigo",unique = false)
    private Puntos puntos;

    @ManyToOne
    @JoinColumn(name = "cedulaUsuario",unique = false)
    private Usuario usuario;*/
}
