package co.edu.uniquindio.unitravel.servicios;


import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;

public interface AdministradorHotelServicio {
    AdministradorHotel verificarLogin(String email, String contrasena) throws Exception;
}
