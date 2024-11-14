package pe.edu.utp.sistemaropa.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pe.edu.utp.sistemaropa.config.Conexion;
import pe.edu.utp.sistemaropa.dao.Operaciones;
import pe.edu.utp.sistemaropa.dto.Factura;
/**
 *
 * @author Nayely
 */
public class FacturaDaoImpl implements Operaciones<Factura> {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conex;

    @Override
    public int create(Factura t) {
        int y = 0;
        String SQL = "INSERT INTO Factura(Nombre, Dni, Total, Vuelto, IdVenta) VALUES(?, ?, ?, ?, ?)";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getDNI());
            ps.setDouble(3, t.getTotal());
            ps.setDouble(4, t.getVuelto());
            ps.setInt(5, t.getIdVenta());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int update(Factura t) {
        int y = 0;
        String SQL = "UPDATE Factura SET Nombre=?, Dni=?, Total=?, Vuelto=? WHERE IdFactura=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getDNI());
            ps.setDouble(3, t.getTotal());
            ps.setDouble(4, t.getVuelto());
            ps.setInt(5, t.getIdFactura());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int delete(int index) {
        int y = 0;
        String SQL = "DELETE FROM Factura WHERE IdFactura=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return y;
    }

    @Override
    public Factura read(int index) {
        Factura c = new Factura();
        String SQL = "SELECT * FROM Factura WHERE IdFactura=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdFactura(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setDNI(rs.getInt(3));
                c.setTotal(rs.getDouble(4));
                c.setVuelto(rs.getDouble(5));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return c;
    }

    @Override
    public List<Factura> readAll() {
        List<Factura> lista = new ArrayList<>();
        String SQL = """
                     SELECT 
                         f.IdFactura, 
                         f.Nombre AS Nombre, 
                         f.Dni AS Dni, 
                         c.Ruc, 
                         v.Fecha, 
                         f.Total, 
                         v.Pago, 
                         f.Vuelto
                     FROM 
                         factura f
                     INNER JOIN 
                         venta v ON f.IdVenta = v.IdVenta
                     INNER JOIN 
                         cliente c ON v.IdCliente = c.IdCliente;""";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura c = new Factura();
                c.setIdFactura(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setDNI(rs.getInt(3));
                c.setRuc(rs.getString(4));
                c.setFecha(rs.getString(5));
                c.setTotal(rs.getDouble(6));
                c.setPago(rs.getDouble(7));
                c.setVuelto(rs.getDouble(8));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    @Override
    public Factura Buscador(int index) {
        Factura cl = new Factura();
        String SQL = "SELECT * FROM Factura WHERE IdFactura=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            if (rs.next()) {
                cl.setNombre(rs.getString("Nombre"));
                cl.setDNI(rs.getInt("DNI"));
                cl.setTotal(rs.getDouble("Total"));
                cl.setVuelto(rs.getDouble("Vuelto"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return cl;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Factura> readAllDisponible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
