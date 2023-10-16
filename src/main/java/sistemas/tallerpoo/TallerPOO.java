package sistemas.tallerpoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemas.tallerpoo.clasesLogicas.Admision;
import sistemas.tallerpoo.clasesLogicas.Box;
import sistemas.tallerpoo.clasesLogicas.Funcionario;
import sistemas.tallerpoo.clasesLogicas.ListaBox;
import sistemas.tallerpoo.clasesLogicas.Medico;
import sistemas.tallerpoo.clasesLogicas.Paciente;
import sistemas.tallerpoo.clasesLogicas.Persona;
import sistemas.tallerpoo.clasesLogicas.Rol;
import sistemas.tallerpoo.clasesLogicas.SectorTrabajo;
import sistemas.tallerpoo.clasesLogicas.Triage;
import sistemas.tallerpoo.datos.AdmisionDatos;
import sistemas.tallerpoo.datos.FuncionarioDatos;
import sistemas.tallerpoo.datos.MedicoDatos;
import sistemas.tallerpoo.datos.PersonaDatos;
import sistemas.tallerpoo.visual.Login;
import sistemas.tallerpoo.visual.Principal;
import sistemas.tallerpoo.visual.RegistroAdmision;
import sistemas.tallerpoo.visual.RegistroUsuario;

/**
 *
 * @author Deian
 */
public class TallerPOO {

    public static void main(String[] args) throws IOException {
        PersonaDatos pDatos = new PersonaDatos();
        FuncionarioDatos fDatos = new  FuncionarioDatos();
        MedicoDatos mDatos = new MedicoDatos();
        AdmisionDatos adDatos = new AdmisionDatos();
        ListaBox lB = new ListaBox();
        
        Persona p = new Persona(46488897, "n", "a", new Date(), "do", 0, "+54", "s", "c");
        Paciente pac = new Paciente(123987, "Pablo", "Preze", new Date(), "dmoiclio", 4561231, "+54 325678978", "casaso", "correo", p);
        Triage tr = new Triage();
        tr.setId(1);
        Box b = null;
        try {
            b = lB.obtenerBoxDesocupado();
            b.setOcupado(true);
        } catch (Exception ex) {
            System.out.println("no hay boxes disponibles");
        }
        Admision a = new Admision(new Date(), new Date(), "herida de cuchillo", pac, tr, b);
        
//        adDatos.agregarAdmision(a);
        //agregarPaciente(pac)
//        pDatos.agregarPersona(p);
        //agregarTriage(tr)
        System.out.println(adDatos.obtenerAdmisiones());
        new RegistroAdmision().setVisible(true);
    }
}