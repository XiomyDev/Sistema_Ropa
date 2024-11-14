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
public class Proveedor {
    private int idProveedor;
    private String nombre;
    private int Telefono; 
    private String direccion;
    private String razon;
    private String Ruc;
    private int idAdministrador;
}
