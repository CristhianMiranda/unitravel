package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdministradorHotel extends Persona implements Serializable {

     @Id
     @EqualsAndHashCode.Include
     @Column(length = 10)
    private int cedula;

    @OneToMany(mappedBy="administradorHotel")
    private List<Hotel>hoteles;
}
