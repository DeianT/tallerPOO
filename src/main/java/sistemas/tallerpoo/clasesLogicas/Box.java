package sistemas.tallerpoo.clasesLogicas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import lombok.AllArgsConstructor;

/**
 *
 * @author famil
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 *  Clase Box
 * 
 */
public class Box {
    private int numero;
    private Date fecha;
    private Date hora;
    private boolean ocupado;
}