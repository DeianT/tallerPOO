package sistemas.tallerpoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import sistemas.tallerpoo.clasesLogicas.Funcionario;
import sistemas.tallerpoo.clasesLogicas.Medico;
import sistemas.tallerpoo.clasesLogicas.Persona;
import sistemas.tallerpoo.clasesLogicas.Rol;
import sistemas.tallerpoo.clasesLogicas.SectorTrabajo;
import sistemas.tallerpoo.datos.FuncionarioDatos;
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
//        Persona p = new Persona(45616133, "Juan", "Gonzales", new Date(5, 12, 2003 - 1900), "domicilio", 42355648, "+54 34500000", "Divorciado", "correo@mail.com");
//        Persona p2 = new Persona(45616133, "Deian", "Teze", new Date(5, 12, 2003 - 1900), "casa", 42355648, "+54 34500000", "Divorciado", "correo@mail.com");
//        System.out.println(p);
//        pDatos.agregarPersona(p);
//        pDatos.agregarPersona(p2);
//        System.out.println(pDatos.obtenerPersonas());
//        System.out.println(pDatos.obtenerPersona(456161733));
//        Persona p = pDatos.obtenerPersona(45616133);
//        System.out.println(p.getApellido());
//        pDatos.imprimirArchivo();
//        pDatos.editarPersona(p);
//        pDatos.imprimirArchivo();
//        new Login().setVisible(true);
//        Persona m = new Medico();
        FuncionarioDatos fDatos = new  FuncionarioDatos();
        Funcionario f = new Funcionario(123456789, "Pedro", "Pascal", new Date(), "comicionli", 123456, "telefono", "soltero, espero", "correo@correo", new SectorTrabajo(), new ArrayList<Rol>());
        fDatos.agregarFuncionario(f);
        System.out.println(fDatos.obtenerFuncionarios());
    }
}