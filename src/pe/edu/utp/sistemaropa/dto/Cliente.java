
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
public class Cliente {
    private int idcliente;
    private int dni;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
    private String Ruc;  

    
}

