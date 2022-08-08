package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Bono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BonoRepo extends JpaRepository<Bono,String> {

    @Query("select b from Bono b where b.cifrado = :cifrado")
    Bono buscarBono(String cifrado);

    @Query("delete  from Bono b where b.cifrado = :cifrado")
    void eliminarBono(String cifrado);
}
