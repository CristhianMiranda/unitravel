package co.edu.uniquindio.unitravel.entidades;


import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario extends Persona implements Serializable {
    @ElementCollection
    private List<String> telefono;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    private List<Denuncia> denuncias;


/*
    @ToString.Include
    @OneToMany(mappedBy="usuario")
    private List<PuntosUsuario> puntosUsuarios;
*/
    @OneToMany(mappedBy="usuario")
    private List<PuntosUsuario> puntosUsuarios;

    @ManyToOne
    @JoinColumn(name = "codigoCiudad",nullable = true)
    private Ciudad ciudad;

    @ToString.Include
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    @NotNull
    private int cedula;

    public Usuario(String nombre, @Email String email, String contraseña, int cedula) {
        super(nombre, email, contraseña);
        this.cedula = cedula;
    }
/*
    public Usuario(String nombre, @Email String email, String contraseña, String andres1805) {
        super(nombre, email, contraseña);
    }*/
}
