package sistemas.tallerpoo.datos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sistemas.tallerpoo.clasesLogicas.HistoriaClinica;
import sistemas.tallerpoo.clasesLogicas.Medico;
import sistemas.tallerpoo.clasesLogicas.Paciente;
import sistemas.tallerpoo.clasesLogicas.Triage;

/**
 * Declaracion de la clase GestorDatos
 *
 */
public class GestorDatos {

    /**
     * Calcula la cantidad de cada color de los Triages registrados en un rango
     * de fechas recibiendo como parametro las dos fechas, f1 y f2, y los jlabel
     * donde se van a mostrar la cantidad de cada uno
     *
     * @param f1 String que contiene la primer fecha del rango de fechas
     * @param f2 String que contiene la segunda fecha del rango de fechas
     * @param Azul JLabel donde se va a settear la cantidad de ese color
     * @param Verde JLabel donde se va a settear la cantidad de ese color
     * @param Naranja JLabel donde se va a settear la cantidad de ese color
     * @param Amarillo JLabel donde se va a settear la cantidad de ese color
     * @param Rojo JLabel donde se va a settear la cantidad de ese color
     */
    public void triagesPorFechas(int[] Desde, int[] Hasta, JLabel Azul, JLabel Verde, JLabel Naranja, JLabel Amarillo, JLabel Rojo) {

        int rojo = 0, naranja = 0, amarillo = 0, verde = 0, azul = 0;

     
           for (Triage t : new TriageDatos().obtenerTriages()) {

            String[] fechaH = t.getFecha().split("/");
            int[] fechaHist = this.pasarArrayAInt(fechaH);

            if (fechaHist[2] == Desde[2] && fechaHist[2] == Hasta[2]) {
                if (fechaHist[1] == Desde[1] && fechaHist[1] == Hasta[1]) {
                    if (fechaHist[0] == Desde[0] && fechaHist[0] == Hasta[0]) {
                        switch (t.getColor().toString()) {
                            case "Rojo":
                                rojo++;
                                break;
                            case "Naranja":
                                naranja++;
                                break;
                            case "Amarillo":
                                amarillo++;
                                break;
                            case "Verde":
                                verde++;
                                break;
                            case "Azul":
                                azul++;
                                break;
                        }
                    } else if (fechaHist[0] >= Desde[0] && fechaHist[0] <= Hasta[0]) {
                        switch (t.getColor().toString()) {
                            case "Rojo":
                                rojo++;
                                break;
                            case "Naranja":
                                naranja++;
                                break;
                            case "Amarillo":
                                amarillo++;
                                break;
                            case "Verde":
                                verde++;
                                break;
                            case "Azul":
                                azul++;
                                break;
                        }
                    }
                } else if (fechaHist[1] >= Desde[1] && fechaHist[1] <= Hasta[1]) {
                    switch (t.getColor().toString()) {
                        case "Rojo":
                            rojo++;
                            break;
                        case "Naranja":
                            naranja++;
                            break;
                        case "Amarillo":
                            amarillo++;
                            break;
                        case "Verde":
                            verde++;
                            break;
                        case "Azul":
                            azul++;
                            break;
                    }

                }
            } else if (fechaHist[2] >= Desde[2] && fechaHist[2] <= Hasta[2]) {
                if (Desde[2] < Hasta[2] && fechaHist[2] == Desde[2]) {
                    if (fechaHist[1] == Desde[1]) {

                        if (fechaHist[0] == Desde[0]) {
                            switch (t.getColor().toString()) {
                                case "Rojo":
                                    rojo++;
                                    break;
                                case "Naranja":
                                    naranja++;
                                    break;
                                case "Amarillo":
                                    amarillo++;
                                    break;
                                case "Verde":
                                    verde++;
                                    break;
                                case "Azul":
                                    azul++;
                                    break;
                            }
                        } else if (fechaHist[0] > Desde[0]) {
                            switch (t.getColor().toString()) {
                                case "Rojo":
                                    rojo++;
                                    break;
                                case "Naranja":
                                    naranja++;
                                    break;
                                case "Amarillo":
                                    amarillo++;
                                    break;
                                case "Verde":
                                    verde++;
                                    break;
                                case "Azul":
                                    azul++;
                                    break;
                            }
                        }
                    } else if (fechaHist[1] > Desde[1]) {
                        switch (t.getColor().toString()) {
                            case "Rojo":
                                rojo++;
                                break;
                            case "Naranja":
                                naranja++;
                                break;
                            case "Amarillo":
                                amarillo++;
                                break;
                            case "Verde":
                                verde++;
                                break;
                            case "Azul":
                                azul++;
                                break;
                        }
                    }

                } else {
                    switch (t.getColor().toString()) {
                        case "Rojo":
                            rojo++;
                            break;
                        case "Naranja":
                            naranja++;
                            break;
                        case "Amarillo":
                            amarillo++;
                            break;
                        case "Verde":
                            verde++;
                            break;
                        case "Azul":
                            azul++;
                            break;
                    }
                }
            }   
    }
        Rojo.setText(Integer.toString(rojo));
        Naranja.setText(Integer.toString(naranja));
        Amarillo.setText(Integer.toString(amarillo));
        Verde.setText(Integer.toString(verde));
        Azul.setText(Integer.toString(azul));   
   }

    /**
     * agrega a un JComboBox todos los DNI de los medicos registrados
     *
     * @param cb JComboBox donde se van a mostrar los DNI
     */
    public void llenarCombo(JComboBox cb) {
        for (Medico p : new MedicoDatos().obtenerMedicos()) {
            cb.addItem(String.valueOf(p.getDni()));
        }
    }

    /**
     * Muestra en un JLabel el nombre completo del medico, en base al DNI
     * seleccionado en el JComboBox
     *
     * @param txt JLabel donde se va a mostrar el nombre completo
     * @param cb JComboBox de donde se selecciona el DNI del medico
     */
    public void mostrarNombresMedicos(JLabel txt, JComboBox cb) {
        for (Medico m : new MedicoDatos().obtenerMedicos()) {
            if (cb.getSelectedItem().toString().equals(Integer.toString(m.getDni()))) {
                txt.setText(m.getNombre().toUpperCase() + " " + m.getApellido().toUpperCase());
            }
        }
    }

    /**
     * Cuenta la cantidad de atenciones que se dieron en un rango de fechas
     * desde f1 hasta f2 y por un medico en particular
     *
     * @param f1 String que contiene la primer fecha del rango de fechas
     * @param f2 String que contiene la seguda fecha del rango de fechas
     * @param med JComboBox del que se obtiene el dni del medico
     * @param cantidad Jlabel donde se settean la cantidad de personas que
     * atendio
     */
    public void atencionPorFechas(int[] Desde, int[] Hasta, JComboBox med, JLabel cantidad) {
 
        int contador = 0;
        for (HistoriaClinica h : new HistoriaClinicaDatos().obtenerHistoriaClinica()) {

            String[] fechaH = h.getFecha().split("/");
            int[] fechaHist = this.pasarArrayAInt(fechaH);

            String dniMedico = Integer.toString(h.getDniMedico());

            if (med.getSelectedItem().toString().equals(dniMedico)) {
                if (fechaHist[2] == Desde[2] && fechaHist[2] == Hasta[2]) {
                    if (fechaHist[1] == Desde[1] && fechaHist[1] == Hasta[1]) {
                        if (fechaHist[0] == Desde[0] && fechaHist[0] == Hasta[0]) {
                            contador++;
                        } else if (fechaHist[0] >= Desde[0] && fechaHist[0] <= Hasta[0]) {
                            contador++;
                        }
                    } else if (fechaHist[1] >= Desde[1] && fechaHist[1] <= Hasta[1]) {
                        contador++;

                    }
                } else if (fechaHist[2] >= Desde[2] && fechaHist[2] <= Hasta[2]) {
                    
                    if (fechaHist[2] == Desde[2]) {
                        if (fechaHist[1] == Desde[1]) {
                            if (fechaHist[0] == Desde[0]) {
                                contador++;
                            } else if (fechaHist[0] > Desde[0]) {
                                contador++;
                            }
                        } else if (fechaHist[1] > Desde[1]) {
                            contador++;
                        }

                    } else {
                        contador++;
                    }
                }
            }
        }
        String resultado = Integer.toString(contador);
        cantidad.setText(resultado);
        
    }

    /**
     * Transforma un Array de Strings a uno de enteros
     *
     * @param Array de Strings
     * @return Array de enteros
     */
    private int[] pasarArrayAInt(String[] array) {
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }
        return arr;
    }

    /**
     * Almacena en un Array de Strings la fecha de nacimiento de todos los
     * medicos registrados
     *
     * @return Array de Strings
     */
    private String[] obtenerFechaNacimientoPacientes() {
        String[] dnis = dnisHistoriaClinica();
        String[] fechasNac = new String[dnis.length];

        for (Paciente p : new PacienteDatos().obtenerPacientes()) {
            String dni = Integer.toString(p.getDni());
            for (int i = 0; i < dnis.length; i++) {
                if (dni.equals(dnis[i])) {
                    fechasNac[i] = p.getFechaNacimiento();
                }
            }
        }
        return fechasNac;
    }

    /**
     * Cuenta la cantiad de atenciones dadas en un rango de fechas desde f1
     * hasta f2, y un rango de edades entre edadDesde y edadHasta
     *
     * @param edadDesde primer edad del rango de edades
     * @param edadHasta segunda edad del rango de edades
     * @param f1 primer fecha del rango de fechas
     * @param f2 segunda fecha del rango de fechas
     * @return cantidad de atenciones dadas, o "" si f1 es mayor que f2 o si
     * alguna de las edades no es positiva
     */
    public String atencionPorFechasYEdades(int edadDesde, int edadHasta, int[] Desde, int[] Hasta) {
        String resultado = "";
        int contador = 0;
        String[] fechasNac = obtenerFechaNacimientoPacientes();


        
        int i = 0;
        for (HistoriaClinica h : new HistoriaClinicaDatos().obtenerHistoriaClinica()) {

            int edad = this.obtenerEdad(fechasNac[i]);
            i++;

            if (edad >= edadDesde && edad <= edadHasta) {

                String[] fechaH = h.getFecha().split("/");
                int[] fechaHist = this.pasarArrayAInt(fechaH);

                if (fechaHist[2] == Desde[2] && fechaHist[2] == Hasta[2]) {
                    if (fechaHist[1] == Desde[1] && fechaHist[1] == Hasta[1]) {
                        if (fechaHist[0] == Desde[0] && fechaHist[0] == Hasta[0]) {
                            contador++;
                        } else if (fechaHist[0] >= Desde[0] && fechaHist[0] <= Hasta[0]) {
                            contador++;
                        }
                    } else if (fechaHist[1] >= Desde[1] && fechaHist[1] <= Hasta[1]) {
                        contador++;

                    }
                } else if (fechaHist[2] >= Desde[2] && fechaHist[2] <= Hasta[2]) {
                    if (Desde[2] < Hasta[2] && fechaHist[2] == Desde[2]) {
                        if (fechaHist[1] == Desde[1]) {

                            if (fechaHist[0] == Desde[0]) {
                                contador++;
                            } else if (fechaHist[0] > Desde[0]) {
                                contador++;
                            }
                        } else if (fechaHist[1] > Desde[1]) {
                            contador++;
                        }
                    } else {
                        contador++;
                    }
                }
                
            }
        }
        resultado = Integer.toString(contador);       
        return resultado; 
    }

    /**
     * Almacena en un Array de String el DNI de los pacientes de todas las
     * historias clinicas registradas
     *
     * @return Array de Strings
     */
    private String[] dnisHistoriaClinica() {
        ArrayList<String> dnis = new ArrayList<>();

        for (HistoriaClinica h : new HistoriaClinicaDatos().obtenerHistoriaClinica()) {
            dnis.add(Integer.toString(h.getDniPaciente()));
        }
        String[] dni = new String[dnis.size()];

        for (int i = 0; i < dnis.size(); i++) {
            dni[i] = dnis.get(i);
        }
        return dni;
    }

    /**
     * Obtiene la edad actual de una persona en base a su fecha de nacimiento
     *
     * @param fechaNaci fecha de nacimiento de la persona
     * @return edad actual de la persona
     */
    private int obtenerEdad(String fechaNaci) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");//especifica el patron de formato
        LocalDate fechaNac = LocalDate.parse(fechaNaci, fmt);//realiza la conversion con el formato especificado
        LocalDate ahora = LocalDate.now();//obtiene la fecha actual del sistema

        Period periodo = Period.between(fechaNac, ahora);
        int edad = periodo.getYears();

        return edad;
    }

    /**
     * Cuenta en un Map,que utiliza como clave el DNI de cada paciente, la
     * cantidad de consultas realizadas por cada uno en un rango de fechas,
     * desde f1 hasta f2 Utiliza la clave del Map para encontrar al paciente y
     * el valor para contar la cantidad de consultas realizadas
     *
     * @param f1 primer fecha del rango de fechas
     * @param f2 segunda fecha del rango de fechas
     * @return Map que contiene en el Valor la cantidad de consultas de cada
     * paciente, o null si f1 es mayor que f2
     */
    public Map<String, Integer> pacienteConsultasRangoDeFechas(int[] Desde, int[] Hasta) {
        Map<String, Integer> map = MapConDnisPacientes();
        

        
            for (HistoriaClinica h : new HistoriaClinicaDatos().obtenerHistoriaClinica()) {
                
            String clave = Integer.toString(h.getDniPaciente());//clave a la q le quiero sumar 1
            int valorActual = map.get(clave);// valor asociado a la clave
            int nuevoValor = 0;

            String[] fechaH = h.getFecha().split("/");
            int[] fechaHist = this.pasarArrayAInt(fechaH);

            if (fechaHist[2] == Desde[2] && fechaHist[2] == Hasta[2]) {
                if (fechaHist[1] == Desde[1] && fechaHist[1] == Hasta[1]) {
                    if (fechaHist[0] == Desde[0] && fechaHist[0] == Hasta[0]) {
                        nuevoValor = valorActual + 1;
                    } else if (fechaHist[0] >= Desde[0] && fechaHist[0] <= Hasta[0]) {
                        nuevoValor = valorActual + 1;
                    }
                } else if (fechaHist[1] >= Desde[1] && fechaHist[1] <= Hasta[1]) {
                    nuevoValor = valorActual + 1;

                }
            } else if (fechaHist[2] >= Desde[2] && fechaHist[2] <= Hasta[2]) {
                if (Desde[2] < Hasta[2] && fechaHist[2] == Desde[2]) {
                    if (fechaHist[1] == Desde[1]) {

                        if (fechaHist[0] == Desde[0]) {
                            nuevoValor = valorActual + 1;
                        } else if (fechaHist[0] > Desde[0]) {
                            nuevoValor = valorActual + 1;
                        }
                    } else if (fechaHist[1] > Desde[1]) {
                        nuevoValor = valorActual + 1;
                    }
                } else {
                    nuevoValor = valorActual + 1;
                }
            }
            map.put(clave, nuevoValor);
        }
           
        return map;
    }

    /**
     * Realiza un mapeo de todos los pacientes registrados, almacenando como
     * clave el DNI y como valor 0 ya que se va a utilizar como contador
     *
     * @return Map con todos los DNIS de los pacientes registrados
     */
    private Map<String, Integer> MapConDnisPacientes() {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (Paciente p : new PacienteDatos().obtenerPacientes()) {
            String dni = Integer.toString(p.getDni());
            map.put(dni, 0);
        }
        return map;
    }

    /**
     * Cuenta en un Map,que utiliza como clave el DNI de cada medico, la
     * cantidad de atenciones realizadas por cada uno en un rango de fechas,
     * desde f1 hasta f2 Utiliza la clave del Map para encontrar al medico y el
     * valor para contar la cantidad de atenciones realizadas
     *
     * @param f1 primer fecha del rango de fechas
     * @param f2 segunda fecha del rango de fechas
     * @return Map que contiene en el Valor la cantidad de atenciones realizadas
     * por cada medico, o null si f1 es mayor que f2
     */
    public Map<String, Integer> medicosAtencionPorFechas(int[] Desde, int[] Hasta) {
        Map<String, Integer> map = MapConDnisMedicos();
        
        
        
         for (HistoriaClinica h : new HistoriaClinicaDatos().obtenerHistoriaClinica()) {
             
            String clave = Integer.toString(h.getDniMedico());//clave a la q le quiero sumar 1
            int valorActual = map.get(clave);// valor asociado a la clave
            int nuevoValor = 0;

            String[] fechaH = h.getFecha().split("/");
            int[] fechaHist = this.pasarArrayAInt(fechaH);

            if (fechaHist[2] == Desde[2] && fechaHist[2] == Hasta[2]) {
                if (fechaHist[1] == Desde[1] && fechaHist[1] == Hasta[1]) {
                    if (fechaHist[0] == Desde[0] && fechaHist[0] == Hasta[0]) {
                        nuevoValor = valorActual + 1;
                    } else if (fechaHist[0] >= Desde[0] && fechaHist[0] <= Hasta[0]) {
                        nuevoValor = valorActual + 1;
                    }
                } else if (fechaHist[1] >= Desde[1] && fechaHist[1] <= Hasta[1]) {
                    nuevoValor = valorActual + 1;

                }
            } else if (fechaHist[2] >= Desde[2] && fechaHist[2] <= Hasta[2]) {
                if (Desde[2] < Hasta[2] && fechaHist[2] == Desde[2]) {
                    if (fechaHist[1] == Desde[1]) {

                        if (fechaHist[0] == Desde[0]) {
                            nuevoValor = valorActual + 1;
                        } else if (fechaHist[0] > Desde[0]) {
                            nuevoValor = valorActual + 1;
                        }
                    } else if (fechaHist[1] > Desde[1]) {
                        nuevoValor = valorActual + 1;
                    }
                } else {
                    nuevoValor = valorActual + 1;
                }
            }
            map.put(clave, nuevoValor);
        }
        System.out.println(map);
           
 
        return map; 
    }

    /**
     * Realiza un mapeo con todos los medicos registrados almacenando como clave
     * el DNI de cada uno
     *
     * @return mapeo con todos los DNIS de los medicos registrados
     */
    private Map<String, Integer> MapConDnisMedicos() {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (Medico m : new MedicoDatos().obtenerMedicos()) {
            String dni = Integer.toString(m.getDni());
            map.put(dni, 0);
        }
        return map;
    }
    
    public boolean controlarRangoFechas(int[] f1, int[] f2)
    {
      if(f1[2]>f2[2])
      {
          return false;        
      }else if(f1[1]>f2[1] && f1[2]==f2[2])
      {
          return false; 
      }else if(f1[0]>f2[0] && f1[1]==f2[1] && f1[2]==f2[2] )
      {
          return false; 
      }
      return true;
    }

    
    
    public boolean controlarEdad(int edad1, int edad2)
    {
        if(edad1 > 0 && edad2 > 0)
        {
           return true;
        }
        return false;
    }
    
    
    
    public int[] convertirFechaAInt(String fecha)
    {
       String[] fechaString = fecha.split("/");
     
       int[] Fecha = this.pasarArrayAInt(fechaString);
       
       return Fecha;
    }
    
    
}
