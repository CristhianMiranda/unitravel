package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Hotel implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 200)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ToString.Include
    private int codigo;
    @Column(length = 50,nullable = false)
    @ToString.Include
    private String nombre;

    @Column(length = 50,nullable = false)
    @ToString.Include
    private String direccion;

    @Column(length = 10,nullable = false)
    @ToString.Include

    private String telefono;

    @Min(0)
    @Max(5)
    @ToString.Include
    private int numeroEstrellas;

    @OneToMany(mappedBy="hotel")
    private List<Denuncia> denuncia;

    @ManyToOne

    @JoinColumn(name = "cedulaAdministradorHotel",nullable = false)
    private AdministradorHotel administradorHotel;

    @OneToMany(mappedBy="hotel")
    private List<Comentario> comentarios;

    /*
    @ManyToOne
    private Comentario comentario;
*/
   // @JoinColumn(name = "codigoCiudad")
    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

    @ManyToMany(mappedBy="hoteles")
    private List<Caracteristica> caracteristicas;

    @OneToMany(mappedBy="hotel")
    private List<Habitacion> habitacion;

    @OneToMany(mappedBy="hotel")
    private List<Foto> foto;

    public Hotel(int codigo, String nombre, String direccion, String telefono, short numeroEstrellas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.numeroEstrellas = numeroEstrellas;
    }
}
