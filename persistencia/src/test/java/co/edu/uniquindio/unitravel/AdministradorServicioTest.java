package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.servicios.AdministradorServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
//@Transactional
public class AdministradorServicioTest {
    //@Autowired
    private AdministradorServicio administradorServicio;

   // @Sql("classpath:dataset.sql")
    @Test
    public void verificarLoginTest()
    {
        try {

            administradorServicio.verificarLogin("cristhian@gmail.com","rokyelperro");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
