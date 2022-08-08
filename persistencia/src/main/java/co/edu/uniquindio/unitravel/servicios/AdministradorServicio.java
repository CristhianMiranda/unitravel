package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;

public interface AdministradorServicio {
    Administrador verificarLogin(String email, String contrasena) throws Exception;
}
