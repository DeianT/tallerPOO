/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas.tallerpoo.clasesLogicas;

/**
 *
 * @author Thiago
 */

/**
 * 
 *  La enumeración `NivelTriage` representa los diferentes niveles de triage utilizados para categorizar la gravedad de un paciente en una situación de emergencia.
 * Los niveles de triage incluyen Rojo, Naranja, Amarillo, Verde y Azul.
 */
public enum NivelTriage 
{

    /**
     *  Representa el nivel de triage "Rojo", que indica una situación de emergencia crítica
     */
    Rojo,

    /**
     *Representa el nivel de triage "Naranja", que indica una situación de urgencia alta
     */
    Naranja,

    /**
     *Representa el nivel de triage "Amarillo", que indica una situación de urgencia moderada
     */
    Amarillo,

    /**
     *Representa el nivel de triage "Verde", que indica una situación de urgencia baja
     */
    Verde,

    /**
     *Representa el nivel de triage "Azul", que suele utilizarse para situaciones no críticas o leves.
     */
    Azul
}
