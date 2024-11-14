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
public class Venta {

    private int idventa;
    private double pago;
    private double vuelto;
    private double total;
    private String fecha;
    private int idCliente;
    private int idTipoDePago;
    private int idVendedor;

}
