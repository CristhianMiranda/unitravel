package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.repositorios.AdministradorHotelRepo;
import org.springframework.stereotype.Service;

@Service
public class AdministradorHotelServicioImpl implements AdministradorHotelServicio{


    private final AdministradorHotelRepo administradorHotelRepo;

    public AdministradorHotelServicioImpl(AdministradorHotelRepo administradorHotelRepo) {
        this.administradorHotelRepo = administradorHotelRepo;
    }

    @Override
    public AdministradorHotel verificarLogin(String email, String contrasena) throws Exception {
        AdministradorHotel administradorHotel = new AdministradorHotel();
        if(obtenerAdministradorCorreo(email)==null)
        {

            throw  new Exception("El correo no corresponde a ningun usuario");

        }else {

            administradorHotel= obtenerAdministradorCorreo(email);

            if(administradorHotel.getContraseña().equals(contrasena))
            {
                System.out.println("El usuario se logeo correctamente");
                return administradorHotel;


            }else
            {

                throw  new Exception("La contraseña es incorrecta");

            }


        }


    }

    public AdministradorHotel obtenerAdministradorCorreo(String email)
    {
        return administradorHotelRepo.findAllByEmail(email).orElse(null);
    }


}
