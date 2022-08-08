package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Foto implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(length = 10)
    @NotNull
    private int codigo;
    @Column(nullable = false,unique = true)
    private String url;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Hotel hotel;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Habitacion habitacion;

    public Foto(int codigo, String url) {
        this.codigo = codigo;
        this.url = url;
    }


}
