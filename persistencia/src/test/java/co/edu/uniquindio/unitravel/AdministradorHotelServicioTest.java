package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
//@Transactional
public class AdministradorHotelServicioTest {
    /**
     * @Autowired
     *     private UsuarioServicio usuarioServicio;
     */
    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @Sql("classpath:dataset.sql")
    @Test
    public void verificarLoginTest()
    {
        try {

           administradorHotelServicio.verificarLogin("cristhian@gmail.com","rokyelperro");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
