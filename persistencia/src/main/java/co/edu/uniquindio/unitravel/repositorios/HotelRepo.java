package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HotelRepo extends JpaRepository<Hotel, String> {
    @Query("select c.hoteles from Hotel h,IN(h.ciudad) c where h.ciudad.codigo = :ciudadCodigo")
    List<Hotel> obtenerListaHoteles(String ciudadCodigo);



    @Query("select h from Hotel h where h.nombre = :nombreHotel")
    Hotel obtenerHotel(String nombreHotel);

    @Query("select h from Hotel h where h.codigo = :codigoHotel")
    Hotel obtenerHotelConCodigo(int codigoHotel);


}
