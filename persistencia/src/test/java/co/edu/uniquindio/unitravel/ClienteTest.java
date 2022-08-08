package co.edu.uniquindio.unitravel;


import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ClienteTest {
/*
    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registrar(){
        Cliente cliente = new Cliente("1010125168", "Paola Andrea Ruiz Londoño", "crishtianandres2001@gmail.com", "Andres1805") ;
        Cliente clienteGuardado = clienteRepo.save(cliente);
        Assertions.assertNotNull(clienteGuardado);
    }

    @Test
    public void eliminar()
    {
        Cliente cliente = new Cliente("1010125168", "Paola Andrea Ruiz Londoño", "crishtianandres2001@gmail.com", "Andres1805") ;
        Cliente clienteGuardado = clienteRepo.save(cliente);

        //Luego lo eliminamos
        clienteRepo.delete(clienteGuardado);

        //Por último, verificamos que si haya quedado borrado
        Cliente clienteBuscado = clienteRepo.findById("1010125168").orElse(null);

        Assertions.assertNull(clienteBuscado);

    }

    @Test
    public void actualizar()
    {
        Cliente cliente = new Cliente("1010125168", "Paola Andrea Ruiz Londoño", "crishtianandres2001@gmail.com", "Andres1805") ;
     //  Cliente cliente = new Cliente("1010125168") ;
        Cliente clienteGuardado = clienteRepo.save(cliente);

        clienteGuardado.setContraseña("lolotro");

      clienteRepo.save(clienteGuardado);


        //Por último, verificamos que si haya quedado borrado
        Cliente clienteBuscado = clienteRepo.findById("1010125168").orElse(null);

        Assertions.assertEquals("lolotro", clienteBuscado.getContraseña());

    }
    @Sql("classpath:dataset.sql")
    @Test
    public void listar()
    {
        /*Cliente cliente = new Cliente("1010125138", "Paola Andrea Ruiz Londoño", "crishtianandres2401@gmail.com", "Andres1805") ;
        Cliente clienteGuardado = clienteRepo.save(cliente);
*/

       /* Cliente cliente1 = new Cliente("1010125168", "Paola Andrea Ruiz Londoño", "crishtianandres2001@gmail.com", "Andres1805") ;
         clienteRepo.save(cliente1);
*/

/*
        List<Cliente> clientes = clienteRepo.findAll();
        System.out.println(clientes);
    }
    @Sql("classpath:dataset.sql")
    @Test
    public void ListaReservas()
    {
      //List<Reserva> reservas = clienteRepo.obtenerListaReservas("pepe@email.com");


       /* Cliente cliente = (Cliente) clienteRepo.obtenerListaReservas("pepe@email.com");*/
      //  reservas.forEach(System.out::println);

   // }
}
