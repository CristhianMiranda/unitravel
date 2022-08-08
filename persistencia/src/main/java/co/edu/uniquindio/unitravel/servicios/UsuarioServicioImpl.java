package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioServicioImpl implements UsuarioServicio {
   private final UsuarioRepo usuarioRepo;
   private final CiudadRepo ciudadRepo;
    private final EmailService emailService;

    private final PuntoRepo puntoRepo;

    private final PuntosUsuarioRepo puntosUsuarioRepo;

    private final BonoRepo bonoRepo;

    private final HotelRepo hotelRepo;

    private final EmailServiceRecuperacionContrasena emailServiceRecuperacionContrasena;

    private final ComentarioRepo comentarioRepo;


    private final DenunciaRepo denunciaRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo, CiudadRepo ciudadRepo, EmailService emailService, PuntoRepo puntoRepo, PuntosUsuarioRepo puntosUsuarioRepo, BonoRepo bonoRepo, HotelRepo hotelRepo, EmailServiceRecuperacionContrasena emailServiceRecuperacionContrasena, ComentarioRepo comentarioRepo, DenunciaRepo denunciaRepo) {
        this.usuarioRepo = usuarioRepo;
        this.ciudadRepo = ciudadRepo;
        this.emailService = emailService;
        this.puntoRepo = puntoRepo;
        this.puntosUsuarioRepo = puntosUsuarioRepo;
        this.bonoRepo = bonoRepo;
        this.hotelRepo = hotelRepo;
        this.emailServiceRecuperacionContrasena = emailServiceRecuperacionContrasena;
        this.comentarioRepo = comentarioRepo;
        this.denunciaRepo = denunciaRepo;
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios(){

        return (ArrayList<Usuario>) usuarioRepo.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) throws Exception {


        if(usuarioRepo.obtenerUsuarioCedula(usuario.getCedula())!=(null))
        {

            throw new Exception("La cédula ya esta registrada a un usuario");

        }else {
            if (String.valueOf(usuario.getCedula()).length() > 6 && String.valueOf(usuario.getCedula()).length() < 11) {
                System.out.println(String.valueOf(usuario.getCedula()).length());
                usuario.setCedula(usuario.getCedula());

            } else {

                throw new Exception("Tu cédula no corresponde a ningún formato permitido, " +
                        "Este debería ser: " +
                        "XXXXXXX (1920)/(2001)          " +
                        "XXXXXXXXXX(2002)/(Vigente)");

            }
            /**
             * Metodo para encapsular todas las excepciones posibles de un valor de email
             */
            if (obtenerUsuarioCorreo(usuario.getEmail()) != null) {
                throw new Exception("El correo ya esta registrado");

            }

            crearBono(15);

            /**
             * Try/Catch para verificar si la sintaxis del correo finalmente corresponde a un correo real
             */
            try {

                enviarCorreo("Bienvenido a unitravel",generarCodigoPuntos(), usuario.getEmail(), usuario.getNombre());

            } catch (Exception e) {

                throw new Exception("Tu correo no sigue la estructura micorreo@dominio.organizacion");

            }



            return usuarioRepo.save(usuario);
        }


       // return usuarioRepo.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerPorId(int id){

        return Optional.ofNullable(usuarioRepo.obtenerUsuarioCedula(id));
    }



    @Override
    public boolean eliminarUsuario(int id) {
        try{
            usuarioRepo.deleteById(String.valueOf(id));
            return true;
        }catch(Exception err){
            return false;
        }
    }







    @Override
    public Usuario registrarUsuario(int cedula, String email, String contrasena, String nombre, int codigoCiudad) throws Exception {

        Usuario usuario = new Usuario();

        usuario.setContraseña(contrasena);

        usuario.setNombre(nombre);

        usuario.setCiudad(ciudadRepo.obtenerCiudadCodigo(codigoCiudad));

        /**
         * Método para encapsular todas las excepciones posibles a la hora de digitar la cédula que es él Id del usuario.
         */
        if(usuarioRepo.obtenerUsuarioCedula(cedula)!=(null))
        {

            throw new Exception("La cédula ya esta registrada a un usuario");

        }else {
            if (String.valueOf(cedula).length() > 6 && String.valueOf(cedula).length() < 11) {
                System.out.println(String.valueOf(cedula).length());
                usuario.setCedula(cedula);

            } else {

                throw new Exception("Tu cédula no corresponde a ningún formato permitido, " +
                        "Este debería ser: " +
                        "XXXXXXX (1920)/(2001)          " +
                        "XXXXXXXXXX(2002)/(Vigente)");

            }


            /**
             * Metodo para encapsular todas las excepciones posibles de un valor de email
             */
            if (obtenerUsuarioCorreo(email) != null) {
                throw new Exception("El correo ya esta registrado");

            } else {

                /**
                 * If para verificar que el correo no este vacío y anidado más if para verificar más tipos de correos erróneos.
                 */
                if (email != "") {
                    int aux = 0;


                    /**
                     * For para analizar todo el correo caracter por caracter y verificar que tenga por lo menos un . y @
                     */
                    for (int i = 0; i < email.length(); i++) {


                        if (email.charAt(i) == '@') {
                            aux++;
                            // usuario.setEmail(email);
                        }

                        if (email.charAt(i) == '.') {
                            aux++;
                            // usuario.setEmail(email);
                        }

                    }


                    /**
                     * Método para guardar el correo después de haber pasado por procesos de verificación.
                     */
                    if (aux == 2) {

                        usuario.setEmail(email);
                       /* String codigoGenerado=generarCodigoPuntos();
                        registrarPuntosUsuario(codigoGenerado,15,usuarioRepo.save(usuario));
                       */
                        crearBono(15);

                        /**
                         * Try/Catch para verificar si la sintaxis del correo finalmente corresponde a un correo real
                         */
                        try {

                            enviarCorreo("Bienvenido a unitravel",generarCodigoPuntos(), email, nombre);

                        } catch (Exception e) {

                            throw new Exception("Tu correo no sigue la estructura micorreo@dominio.organizacion");

                        }



                        //  System.out.println(generarCodigoPuntos());
                        return usuarioRepo.save(usuario);

                    }else {
                        throw  new Exception("Tu correo no sigue la estructura");
                    }
                } else {

                    throw new Exception("Tu correo no puede estar vació, Sigue la estructura micorreo@dominio.organizacion");

                }

            }



        }
    }

    @Override
    public void crearBono(int cantidad) {
        /*
        Puntos puntos = new Puntos();
        puntos.setCantidad(cantidad);


        Bono bono = new Bono();
        bono.setCantidad(cantidad);
        bono.setPuntos(puntoRepo.save(puntos));
        */
        Bono bono = new Bono();
        bono.setCantidad(cantidad);
        bono.setUsado(false);
        bono.setCifrado(generarCodigoPuntos());
        bonoRepo.save(bono);
    }

    @Override
    public void usarBono(String cifrado,Usuario usuario) throws Exception {

        if(buscarBono(cifrado)==null||buscarBono(cifrado).isUsado())
        {
            throw new Exception("NO EXISTE BONO O YA HA SIDO USADO");
        }else {
            Puntos puntos = new Puntos();
         //   puntos.setCodigo(0);
            puntos.setCantidad(buscarBono(cifrado).getCantidad());
            puntos.setBono(buscarBono(cifrado));
            puntos=puntoRepo.save(puntos);

            PuntosUsuario puntosUsuario = new PuntosUsuario();
            puntosUsuario.setPuntos(puntos);
            puntosUsuario.setUsuario(usuario);
            puntosUsuario=puntosUsuarioRepo.save(puntosUsuario);

            List<PuntosUsuario> puntosUsuarios = new ArrayList<>();
            puntosUsuarios.add(puntosUsuario);

            usuario.setPuntosUsuarios(puntosUsuarios);

            Bono bono = new Bono();

            bono=buscarBono(cifrado);

            bono.setPuntos(puntos);
            bono.setUsado(true);
            bonoRepo.save(bono);
            /*
            buscarBono(cifrado).setPuntos(puntos);
            buscarBono(cifrado).setUsado(true);
            BonoRepo
            */
        }



        /* System.out.println();
        if(buscarBono(cifrado)==null&&buscarBono(cifrado).isUsado())
        {
            throw new Exception("El bono no existe o ya ha sido usado.");
        }else {
        Puntos puntos = new Puntos();
        puntos.setCantidad(buscarBono(cifrado).getCantidad());
        puntos.setBono(buscarBono(cifrado));

        PuntosUsuario puntosUsuario = new PuntosUsuario();
        puntosUsuario.setPuntos(puntoRepo.save(puntos));
        puntosUsuario.setUsuario(usuario);
        puntosUsuarioRepo.save(puntosUsuario);
        buscarBono(cifrado).setPuntos(puntoRepo.save(puntos));
        buscarBono(cifrado).setUsado(true);
        }*/
    }

    @Override
    public Usuario verificarLogin(String email, String contrasena) throws Exception {
        Usuario usuario = new Usuario();
        if(obtenerUsuarioCorreo(email)==null)
        {

            throw  new Exception("El correo no corresponde a ningun usuario");

        }else {

            usuario= obtenerUsuarioCorreo(email);

            if(usuario.getContraseña().equals(contrasena))
            {
                System.out.println("El usuario se logeo correctamente");
                return usuario;


            }else
            {

                throw  new Exception("La contraseña es incorrecta");

            }


        }


    }









        /*Usuario usuario = new Usuario();
        usuario=usuarioRepo.obtenerEmail(email);
        System.out.println(usuario.getEmail().toString());
        if(usuario.getEmail()==email)
        {

            if (usuario.getContraseña() != contrasena) {
                throw new Exception("Tu contreseña no corresponde al correo digitado.");
            }
            else {
                return usuario;
            }
        }else {
            throw  new Exception("El correo no existe a ningun usuario registrado");
        }*/



    public Bono buscarBono(String cifrado)
    {
        return bonoRepo.buscarBono(cifrado);
    }

    /**
     * Método para obtener un usuario con un correo digitado
     * @param email correo del usuario
     * @return usuario asociado a ese correo
     */
    public  Usuario obtenerUsuarioCorreo(String email)
    {
        return usuarioRepo.findAllByEmail(email).orElse(null);
    }





    /**
     * Metodo para enviar correo
     * @param asunto encabezado de correo
     * @param contenido información que se quiere enviar
     * @param destinatario correo de persona que recibir su información
     * @param datos Es otro dato diferente al correo del usuario
     */
    public void enviarCorreo(String asunto,String contenido,String destinatario,String datos)
    {
        boolean estado = emailService.enviarEmail(asunto, contenido, destinatario,datos);
    }

    public void enviarCorreoRecuperacion(String asunto,String contenido,String destinatario,String datos)
    {
        boolean estado = emailServiceRecuperacionContrasena.enviarEmail(asunto,contenido,destinatario,datos);
    }

/*
    public void registrarPuntosUsuario(String codigo, int cantidad,Usuario usuario)
    {
        Puntos puntos = new Puntos();
        puntos.setCodigo(codigo);
        puntos.setCantidad(cantidad);
        puntos.setUsado(false);
        puntoRepo.save(puntos);

        PuntosUsuario puntosUsuario = new PuntosUsuario();
        puntosUsuario.setPuntos(puntos);
        puntosUsuario.setUsuario(usuario);
        //puntosUsuario.setCodigo(codigo);
        puntosUsuarioRepo.save(puntosUsuario);
    }
*/

    public  String generarCodigoPuntos()
    {
        StringBuilder builder;
        String theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";
        builder = new StringBuilder(8);

        for (int m = 0; m < 8; m++) {

            // generate numeric
            int myindex
                    = (int)(theAlphaNumericS.length()
                    * Math.random());

            // add the characters
            builder.append(theAlphaNumericS
                    .charAt(myindex));
        }
        //System.out.println(builder.toString());
        return builder.toString();
    }



    @Override
    public Hotel obtenerHotel(String nombreHotel) throws Exception {

        if(hotelRepo.obtenerHotel(nombreHotel)==null)
        {
            throw new Exception("El hotel no se encontro");
        }
       // System.out.println(hotelRepo.obtenerHotel(nombreHotel).toString());
        return hotelRepo.obtenerHotel(nombreHotel);
    }



    @Override
    public void recuperarContrasenaCorreo(String email) throws Exception{
        if(usuarioRepo.recuperarContrasena(email)==null)
        {
            throw new Exception("El correo no se encontro asociada a ninguna cuenta");
        }
        enviarCorreoRecuperacion("Recuperacion de contraseña",usuarioRepo.recuperarContrasena(email).getContraseña(),email,usuarioRepo.recuperarContrasena(email).getContraseña());

        // return usuarioRepo.recuperarContrasena(email);
    }



    @Override
    public Comentario comentarHotel(int cedulaUsuario,int codigoHotel, String mensaje, double calificacion) throws Exception {
        if(mensaje.length()>220) {
            throw new Exception("El mensaje es demasiado largo");
        }
        if(mensaje==null||mensaje.equals("")) {
            throw new Exception("Debes ingresar un mensaje");
        }
        Comentario comentario = new Comentario(mensaje,calificacion);
        LocalDate tiempo = LocalDate.now();
        //   System.out.println(tiempo.toString());
        comentario.setFechaCalificacion(LocalDate.now());
        comentario.setUsuario(obtenerUsuarioCedula(cedulaUsuario));
        comentario.setHotel(obtenerHotelConCodigo(codigoHotel));



        return comentarioRepo.save(comentario);

    }
    public Hotel obtenerHotelConCodigo(int codigoHotel)
    {
        return hotelRepo.obtenerHotelConCodigo(codigoHotel);
    }
    public Usuario obtenerUsuarioCedula(int cedulaUsuario)
    {
        return usuarioRepo.obtenerUsuarioCedula(cedulaUsuario);
    }

    @Override
    public Denuncia denunciarHotel(int cedulaUsuario, int codigoHotel,String mensaje) throws Exception {
        if(mensaje.length()>220) {
            throw new Exception("El mensaje es demasiado largo");
        }
        if(mensaje==null||mensaje.equals("")) {
            throw new Exception("Debes ingresar un mensaje");
        }
        System.out.println("prueba");
        Denuncia denuncia = new Denuncia(mensaje);

        System.out.println("pruebas");
        denuncia.setUsuario(obtenerUsuarioCedula(cedulaUsuario));
        denuncia.setHotel(obtenerHotelConCodigo(codigoHotel));

        return denunciaRepo.save(denuncia);
    }


}
