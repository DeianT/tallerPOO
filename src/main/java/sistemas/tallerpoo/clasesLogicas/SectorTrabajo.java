package sistemas.tallerpoo.clasesLogicas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Deian
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 *  La clase `SectorTrabajo` representa un sector de trabajo en el sistema de salud
 */
public class SectorTrabajo {
    private String nombre;// El nombre del sector de trabajo.
    
    /**
     *
     * @return Devuelve el Nombre del Sector de Trabajo
     */
    @Override
    public String toString(){
        return "SectorTrabajo(" + nombre +")";
    }
}