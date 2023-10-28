package sistemas.tallerpoo;

import java.io.IOException;
import sistemas.tallerpoo.datos.AdmisionDatos;
import sistemas.tallerpoo.datos.FuncionarioDatos;
import sistemas.tallerpoo.datos.MedicoDatos;
import sistemas.tallerpoo.datos.PersonaDatos;
import sistemas.tallerpoo.visual.Login;


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
