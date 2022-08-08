package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.util.ArrayList;
import java.util.Optional;

public interface    UsuarioServicio {




    /**
     * Método para registrar usuario
     * @param cedula Es la id del usuario este debe ser único
     * @param email es el correo del usuario y debe ser único
     * @param contrasena esta es la contraseña del usuario asociada a la cuenta del usuario
     * @param nombre corresponde al nombre digitado por el usuario
     * @param codigoCiudad corresponde a la ciudad que se encuentra el usuario.
     * @return
     * @throws Exception
     */
    Usuario registrarUsuario(int cedula,String email,String contrasena,String nombre,int codigoCiudad) throws Exception;

    void crearBono(int cantidad);

    void usarBono(String cifrado,Usuario usuario) throws Exception;

    Usuario verificarLogin(String email, String contrasena) throws Exception;


    /**Buscar hoteles
     * Metodo para obtener hotel a partir del nombre del hotel
     * @param nombreHotel representa el nombre de un hotel
     * @return el hotel dependiendo del nombre que se busca
     * @throws Exception No existe un hotel con ese nombre
     */
    Hotel obtenerHotel(String nombreHotel)  throws Exception;







    /**NOINOSNOSNOSNOS
     * Metodo para recuperar la contraseña de la cuenta de usuario con el correo
     * @param email correo de cuenta de usuario
     * @return contraseña de cuenta
     * @throws Exception no existe el correo asociada a ninguna cuenta
     */
    void recuperarContrasenaCorreo(String email) throws Exception;







    /**
     * Metodo para comentar hotel por usuario
     * @param cedulaUsuario codigo de usuario que comentara
     * @param codigoHotel codigo de hotel el cual se comentara
     * @param mensaje     mensaje de denuncia
     * @param calificacion calificacion del hotel
     * @return Comentario realizado
     * @throws Exception El mensajee es muy corto
     */
    Comentario comentarHotel(int cedulaUsuario,int codigoHotel, String mensaje, double calificacion) throws Exception;


    /**
     * Metodo para hacer una denuncia del usuario a el hotel
     * @param cedulaUsuario codigo de usuario que denunciara
     * @param codigoHotel   codigo de hotel denunciado
     * @param mensaje       mensaje de exposicion de denuncia
     * @return  una denuncia
     * @throws Exception    El mensaje es muy corto
     */
    Denuncia denunciarHotel(int cedulaUsuario, int codigoHotel, String mensaje) throws Exception;










    ArrayList<Usuario> obtenerUsuarios();
    Usuario guardarUsuario(Usuario usuario) throws Exception;
    Optional<Usuario> obtenerPorId(int id);
    boolean eliminarUsuario(int id);



}
