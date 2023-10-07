package sistemas.tallerpoo;

import java.util.Date;
import sistemas.tallerpoo.clasesLogicas.Persona;

/**
 *
 * @author Deian
 */
public class TallerPOO {

    public static void main(String[] args) {
        Persona p = new Persona(45616133, "Deian", "Teze", new Date(5, 12, 2003 - 1900), "casa", 4235648, "+54 34500000", "Divorciado", "correo@mail.com");
        System.out.println(p);
    }
}
