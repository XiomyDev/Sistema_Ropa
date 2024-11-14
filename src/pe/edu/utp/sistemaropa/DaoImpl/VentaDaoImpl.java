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
import pe.edu.utp.sistemaropa.dto.Venta;
/**
 *
 * @author Nayely
 */
public class VentaDaoImpl implements Operaciones<Venta> {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conex;

    @Override
    public int create(Venta v) {
        int y = 0;
        String SQL = "INSERT INTO Venta(Pago, Vuelto, Total, Fecha, IdCliente, IdTipoDePago, IdVendedor) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setDouble(1, v.getPago());
            ps.setDouble(2, v.getVuelto());
            ps.setDouble(3, v.getTotal());
            ps.setString(4, v.getFecha());
            ps.setInt(5, v.getIdCliente());
            ps.setInt(6, v.getIdTipoDePago());
            ps.setInt(7, v.getIdVendedor());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return y;
    }

    @Override
    public int update(Venta v) {
        int y = 0;
        String SQL = "UPDATE Venta SET Pago=?, Vuelto=?, Total=?, Fecha=? WHERE IdVenta=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setDouble(1, v.getPago());
            ps.setDouble(2, v.getVuelto());
            ps.setDouble(3, v.getTotal());
            ps.setString(4, v.getFecha());
            ps.setInt(5, v.getIdventa());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int delete(int index) {
        int y = 0;
        String SQL = "DELETE FROM Venta WHERE IdVenta=?";
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
    public Venta read(int index) {
        Venta v = new Venta();
        String SQL = "SELECT * FROM Venta WHERE IdVenta=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            if (rs.next()) {
                v.setIdventa(rs.getInt(1));
                v.setPago(rs.getDouble(2));
                v.setVuelto(rs.getDouble(3));
                v.setTotal(rs.getDouble(4));
                v.setFecha(rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return v;
    }

    @Override
    public List<Venta> readAll() {
        List<Venta> lista = new ArrayList<>();
        String SQL = "SELECT * FROM Venta";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta v = new Venta();
                v.setIdventa(rs.getInt(1));
                v.setPago(rs.getDouble(2));
                v.setVuelto(rs.getDouble(3));
                v.setTotal(rs.getDouble(4));
                v.setFecha(rs.getString(5));
                lista.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    @Override
    public Venta Buscador(int index) {
        Venta v = new Venta();
        String SQL = "SELECT * FROM Venta WHERE IdVenta=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            if (rs.next()) {
                v.setPago(rs.getDouble("Pago"));
                v.setVuelto(rs.getDouble("Vuelto"));
                v.setTotal(rs.getDouble("Total"));
                v.setFecha(rs.getString("Fecha"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return v;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Venta> readAllDisponible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
