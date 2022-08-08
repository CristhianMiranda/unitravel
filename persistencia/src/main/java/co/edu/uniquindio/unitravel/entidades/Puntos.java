package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Puntos implements Serializable {


    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private int codigo;

    @Column(nullable = false)
    @Min(0)
    private int cantidad;

/*
    @OneToMany(mappedBy="puntos")
    private List<PuntosUsuario> puntosUsuarios;


*/

    @OneToOne
    private Bono bono;

    @OneToMany(mappedBy="puntos")
    private List<PuntosUsuario> puntosUsuarios;
/*
    @Column(nullable = false)
    private boolean usado;
*/

}
