package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString(onlyExplicitlyIncluded = true)
public class Persona implements Serializable {


    //@ToString.Include
    @Column(length = 80,nullable = false)
    @NotBlank
    private String nombre;


   @ToString.Include
    @Email
    @Column(length = 50,nullable = false,unique = true)
   @NotBlank
    private String email;


@ToString.Include
    @Column(length = 30,nullable = false)
@NotBlank
    private String contraseña;




}
