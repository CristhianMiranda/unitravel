package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HotelServicioImpl implements  HotelServicio{


    private final HotelRepo hotelRepo;


    public HotelServicioImpl(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }


    @Override
    public ArrayList<Hotel> obtenerHoteles() {
        return (ArrayList<Hotel>) hotelRepo.findAll();
    }
}
