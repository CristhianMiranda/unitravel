package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cama implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 2)
    private int codigo;

    @ManyToMany
    private List<Habitacion> habitaciones;

    private boolean tipo;

    public Cama(int codigo) {
        this.codigo = codigo;
    }



}
