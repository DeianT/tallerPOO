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
public class SectorTrabajo {
    private String nombre;
    
    /**
     *
     * @return Devuelve el Nombre del Sector de Trabajo
     */
    @Override
    public String toString(){
        return "SectorTrabajo(" + nombre +")";
    }
}