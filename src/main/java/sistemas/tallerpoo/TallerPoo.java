package sistemas.tallerpoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemas.tallerpoo.clasesLogicas.Admision;
import sistemas.tallerpoo.clasesLogicas.Box;
import sistemas.tallerpoo.clasesLogicas.Especialidad;
import sistemas.tallerpoo.clasesLogicas.Funcionario;
import sistemas.tallerpoo.clasesLogicas.Medico;
import sistemas.tallerpoo.clasesLogicas.Paciente;
import sistemas.tallerpoo.clasesLogicas.Persona;
import sistemas.tallerpoo.clasesLogicas.Rol;
import sistemas.tallerpoo.clasesLogicas.SectorTrabajo;
import sistemas.tallerpoo.clasesLogicas.Triage;
import sistemas.tallerpoo.clasesLogicas.Usuario;
import sistemas.tallerpoo.datos.AdmisionDatos;
import sistemas.tallerpoo.datos.EspacialidadDatos;
import sistemas.tallerpoo.datos.BoxDatos;
import sistemas.tallerpoo.datos.FuncionarioDatos;
import sistemas.tallerpoo.datos.MedicoDatos;
import sistemas.tallerpoo.datos.PersonaDatos;
import sistemas.tallerpoo.datos.PacienteDatos;
import sistemas.tallerpoo.datos.RolDatos;
import sistemas.tallerpoo.datos.TriageDatos;
import sistemas.tallerpoo.visual.Login;
import sistemas.tallerpoo.visual.Principal;
import sistemas.tallerpoo.visual.RegistroAdmision;
import sistemas.tallerpoo.visual.RegistroUsuario;

/**
 *
 * @author Deian
 */
public class TallerPoo {
    public static void main(String[] args) throws IOException {
        PersonaDatos pDatos = new PersonaDatos();
        FuncionarioDatos fDatos = new  FuncionarioDatos();
        MedicoDatos mDatos = new MedicoDatos();
        AdmisionDatos adDatos = new AdmisionDatos();
        new Login().setVisible(true);
    }
}
