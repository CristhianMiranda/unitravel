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
public class Telefono implements Serializable {


    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    @JoinColumn(name = "cedulaUsuario")
    private Usuario usuario;


    @Id
    @EqualsAndHashCode.Include
    private String numeroTelefono;


    @Column(length = 200)
    private String descripcion;
}
