package co.edu.uniquindio.unitravel.controllers;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    UsuarioServicioImpl usuarioServicioImpl;


    @GetMapping("/usuario")
    public ArrayList<Usuario> obtenerUsuarios(){

        return usuarioServicioImpl.obtenerUsuarios();
    }



    @PostMapping(path ="/save")
    public Usuario guardarUsuario(@RequestBody @Valid Usuario usuario) throws Exception {
        //return usuarioServicioImpl.registrarUsuario(usuario.getCedula(),usuario.getEmail(),usuario.getContraseña(),usuario.getNombre(),2);
        return usuarioServicioImpl.guardarUsuario(usuario);
    }

/*
    @PostMapping(path ="/save")
    public String guardarUsuario(@RequestBody  Usuario usuario)throws Exception{
        String aux ="";
        try
        {
            //return this.usuarioServicioImpl.guardarUsuario(usuario);
            this.usuarioServicioImpl.registrarUsuario(usuario.getCedula(),usuario.getEmail(),usuario.getContraseña(), usuario.getNombre(), 2);
            return usuarioServicioImpl.obtenerUsuarioCorreo(usuario.getEmail()).toString();
        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("SSSAAAAAAAAAAAAS");
           aux = e.getMessage();
           System.out.println(aux);
           return aux;
        }



    }
*/
    @PostMapping(path ="/error")
    public String error(Exception e)
    {
        System.out.println(e.getMessage());
        return e.getMessage();
    }


    @GetMapping( path = "/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable("id") int id) {
        return this.usuarioServicioImpl.obtenerPorId(id);
    }

    @GetMapping( path = "/login/{email}/{contraseña}")
    public Usuario verificarLogin(@PathVariable("email") String email,@PathVariable("contraseña") String contrasena) throws Exception {
        return this.usuarioServicioImpl.verificarLogin(email,contrasena);
    }

    /*
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }
     */

    @DeleteMapping( path = "/delete/{id}")
    public String eliminarPorId(@PathVariable("id") int id){
        boolean ok = this.usuarioServicioImpl.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }



}
