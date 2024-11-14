

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
import pe.edu.utp.sistemaropa.dto.DetalleVenta;
/**
 *
 * @author Nayely
 */
public class DetalleVentaDaoImpl implements Operaciones<DetalleVenta> {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conex;

    @Override
    public int create(DetalleVenta t) {
        int y = 0;
        String SQL = "INSERT INTO detalleventa(Detalle) VALUES(?)";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, t.getDetalle());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int update(DetalleVenta t) {
        int y = 0;
        String SQL = "UPDATE detalleventa SET Detalle=? WHERE IdDetalleVenta=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, t.getDetalle());
            ps.setInt(2, t.getIdDetalleVenta());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int delete(int index) {
        int y = 0;
        String SQL = "DELETE FROM detalleventa WHERE IdDetalleVenta=?";
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
    public DetalleVenta read(int index) {
        DetalleVenta c = new DetalleVenta();
        String SQL = "SELECT * FROM detalleventa WHERE IdDetalleVenta=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdDetalleVenta(rs.getInt(1));
                c.setDetalle(rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return c;
    }

    @Override
    public List<DetalleVenta> readAll() {
        List<DetalleVenta> lista = new ArrayList<>();
        String SQL = "SELECT * FROM detalleventa";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleVenta t = new DetalleVenta();
                t.setIdDetalleVenta(rs.getInt(1));
                t.setDetalle(rs.getString(2));
                lista.add(t);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    @Override
    public DetalleVenta Buscador(int index) {
        DetalleVenta cl = new DetalleVenta();
        String SQL = "SELECT * FROM detalleventa WHERE IdDetalleVenta=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            if (rs.next()) {
                cl.setDetalle(rs.getString("Detalle"));
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
    public List<DetalleVenta> readAllDisponible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
