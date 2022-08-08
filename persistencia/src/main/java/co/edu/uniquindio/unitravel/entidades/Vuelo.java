package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vuelo implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 6)
    private String codigo;

    private boolean estado;
    @Column(length = 30,nullable = false)
    private String aerolinea;

    @OneToMany(mappedBy="vuelo")
    private List<Silla> Sillas;



    @ManyToOne
    @JoinColumn(name = "codigoCiudadDestino",nullable = false)
    private Ciudad ciudadDestino;

    @ManyToOne
    @JoinColumn(name = "codigoCiudadOrigen",nullable = false)
    private Ciudad ciudadOrigen;




    public Vuelo(String codigo, boolean estado, String aerolinea) {
        this.codigo = codigo;
        this.estado = estado;
        this.aerolinea = aerolinea;
    }
}
