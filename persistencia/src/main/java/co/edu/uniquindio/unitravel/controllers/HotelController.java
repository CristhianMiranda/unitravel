package co.edu.uniquindio.unitravel.controllers;


import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.HotelServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping
@CrossOrigin("*")
public class HotelController {

    @Autowired
    HotelServicioImpl hotelServicioImpl;



    @GetMapping("/hoteles")
    public ArrayList<Hotel> obtenerHoteles() {
        return hotelServicioImpl.obtenerHoteles();
    }



}

