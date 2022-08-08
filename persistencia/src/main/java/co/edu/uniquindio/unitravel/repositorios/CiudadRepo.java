package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepo extends JpaRepository<Hotel, String> {

    @Query("select c from Ciudad c where c.nombre = :nombreCiudad")
    Ciudad obtenerCiudadNombre(String nombreCiudad);

    @Query("select c from Ciudad c where c.codigo = :codigo")
    Ciudad obtenerCiudadCodigo(int codigo);
}
