/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.sistemaropa.dto;
/**
 *
 * @author Nayely
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Administrador {
    private int idAdministrador;
    private String nombre;
    private String apellido;
    private int telefono;
    private int DNI;
    private int idUsuario;
    
}
