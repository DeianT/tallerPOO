package Main;

import java.util.ArrayList;
import java.util.Date;
import ClaseLogicas.Persona;
import ClaseLogicas.Gestor;
import ClaseLogicas.Rol;
import ClaseLogicas.SectorTrabajo;

/**
 *
 * @author Deian
 */
public class TallerPOO {

    public static void main(String[] args) {
        //Persona p = new Persona(45616133, "Deian", "Teze", new Date(5, 12, 2003 - 1900), "casa", 4235648, "+54 34500000", "Divorciado", "correo@mail.com");
        //System.out.println(p);
        
        
        
        
        //Prueba del contructor de gestor con jerarquias multiclases
        ArrayList<Rol> a = new ArrayList<Rol>();
        SectorTrabajo b = new SectorTrabajo();
        Gestor g = new Gestor(1,"thiago","ramon","28/08/2003","casa",123,"+123","soltero","a@a.com",b,a);
        System.out.println(g.getTrabajaEn() + " " + g.getRolesSistema());
        
    }
}
