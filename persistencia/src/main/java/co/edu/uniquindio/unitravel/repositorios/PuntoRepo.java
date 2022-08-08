package co.edu.uniquindio.unitravel.repositorios;
import co.edu.uniquindio.unitravel.entidades.Puntos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntoRepo extends JpaRepository<Puntos, String> {


}