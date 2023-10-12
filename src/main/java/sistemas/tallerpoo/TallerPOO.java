package sistemas.tallerpoo;

import java.io.IOException;
import java.util.Date;
import sistemas.tallerpoo.clasesLogicas.Persona;
import sistemas.tallerpoo.datos.PersonaDatos;
import sistemas.tallerpoo.visual.Login;
import sistemas.tallerpoo.visual.RegistroUsuario;

/**
 *
 * @author Deian
 */
public class TallerPOO {

    public static void main(String[] args) throws IOException {
        PersonaDatos pDatos = new PersonaDatos();
        Persona p = new Persona(456161733, "Juan", "Gonzales", new Date(5, 12, 2003 - 1900), "domicilio", 42355648, "+54 34500000", "Divorciado", "correo@mail.com");
//        Persona p2 = new Persona(45616133, "Deian", "Teze", new Date(5, 12, 2003 - 1900), "casa", 42355648, "+54 34500000", "Divorciado", "correo@mail.com");
//        System.out.println(p);
//        pDatos.agregarPersona(p);
//        pDatos.agregarPersona(p2);
//        System.out.println(pDatos.obtenerPersonas());
//        System.out.println(pDatos.obtenerPersona(45616733));
//        Persona p = pDatos.obtenerPersona(45616733);
//        System.out.println(p.getApellido());
//        pDatos.imprimirArchivo();
//        pDatos.editarPersona(p);
        pDatos.imprimirArchivo();
//        new Login().setVisible(true);
    }
}
