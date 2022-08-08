package co.edu.uniquindio.unitravel.repositorios;
import co.edu.uniquindio.unitravel.entidades.PuntosUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntosUsuarioRepo extends JpaRepository<PuntosUsuario, String> {


}