/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.sistemaropa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Nayely
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Historial {

    private int idHistorial;
    private String nombre;
    private int DNI;
    private double total;
    private double vuelto;

    private String apellido;
    private String ruc;
    private String fecha;
    private double pago;

}
