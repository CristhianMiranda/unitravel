package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.repositorios.AdministradorHotelRepo;
import co.edu.uniquindio.unitravel.repositorios.AdministradorRepo;

public class AdministradorServicioImpl implements AdministradorServicio {
    private final AdministradorRepo administradorRepo;

    public AdministradorServicioImpl(AdministradorRepo administradorRepo) {
        this.administradorRepo = administradorRepo;
    }

    @Override
    public Administrador verificarLogin(String email, String contrasena) throws Exception {
        Administrador administrador = new Administrador();
        if(obtenerAdministradorCorreo(email)==null)
        {

            throw  new Exception("El correo no corresponde a ningun usuario");

        }else {

            administrador= obtenerAdministradorCorreo(email);

            if(administrador.getContraseña().equals(contrasena))
            {
                System.out.println("El usuario se logeo correctamente");
                return administrador;


            }else
            {

                throw  new Exception("La contraseña es incorrecta");

            }


        }


    }

    public Administrador obtenerAdministradorCorreo(String email)
    {
        return administradorRepo.findAllByEmail(email).orElse(null);
    }
}
