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
import pe.edu.utp.sistemaropa.dto.Historial;
/**
 *
 * @author Nayely
 */
public class HistorialDaoImpl implements Operaciones<Historial> {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conex;

    @Override
    public int create(Historial t) {
        int y = 0;
        String SQL = "INSERT INTO Historial(Nombre, Dni, Total, Vuelto) VALUES(?, ?, ?, ?)";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getDNI());
            ps.setDouble(3, t.getTotal());
            ps.setDouble(4, t.getVuelto());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int update(Historial t) {
        int y = 0;
        String SQL = "UPDATE Historial SET Nombre=?, Dni=?, Total=?, Vuelto=? WHERE IdHistorial=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getDNI());
            ps.setDouble(3, t.getTotal());
            ps.setDouble(4, t.getVuelto());
            ps.setInt(5, t.getIdHistorial());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int delete(int index) {
        int y = 0;
        String SQL = "DELETE FROM Historial WHERE IdHistorial=?";
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
    public Historial read(int index) {
        Historial c = new Historial();
        String SQL = "SELECT * FROM Historial WHERE IdHistorial=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdHistorial(rs.getInt(1));
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
    public List<Historial> readAll() {
        List<Historial> lista = new ArrayList<>();
        String SQL = "SELECT \n"
                + "    c.Nombre, \n"
                + "    c.Apellido, \n"
                + "    c.Dni, \n"
                + "    c.Ruc, \n"
                + "    v.Fecha, \n"
                + "    v.Total, \n"
                + "    v.Pago, \n"
                + "    v.Vuelto\n"
                + "FROM \n"
                + "    cliente c\n"
                + "INNER JOIN \n"
                + "    venta v ON c.IdCliente = v.IdCliente;";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Historial c = new Historial();
                c.setNombre(rs.getString(1));
                c.setApellido(rs.getString(2));
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
    public Historial Buscador(int index) {
        Historial cl = new Historial();
        String SQL = "SELECT * FROM Historial WHERE IdHistorial=?";
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
    public List<Historial> readAllDisponible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
