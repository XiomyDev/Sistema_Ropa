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
import pe.edu.utp.sistemaropa.dto.Vendedor;
/**
 *
 * @author Nayely
 */
public class VendedorDaoImpl implements Operaciones<Vendedor> {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conex;

    @Override
    public int create(Vendedor v) {
        int y = 0;
        String SQL = "INSERT INTO Vendedor(Nombre, Apellido, Telefono, Dni, IdUsuario) VALUES(?, ?, ?, ?, ?)";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, v.getNombre());
            ps.setString(2, v.getApellido());
            ps.setInt(3, v.getTelefono());
            ps.setInt(4, v.getDNI());
            ps.setInt(5, v.getIdUsuario());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int update(Vendedor v) {
        int y = 0;
        String SQL = "UPDATE Vendedor SET Nombre=?, Apellido=?, Telefono=?, Dni=?, IdUsuario=? WHERE IdVendedor=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, v.getNombre());
            ps.setString(2, v.getApellido());
            ps.setInt(3, v.getTelefono());
            ps.setInt(4, v.getDNI());
            ps.setInt(5, v.getIdUsuario());
            ps.setInt(6, v.getIdVendedor());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int delete(int index) {
        int y = 0;
        String SQL = "DELETE FROM Vendedor WHERE IdVendedor=?";
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
    public Vendedor read(int index) {
        Vendedor v = new Vendedor();
        String SQL = "SELECT * FROM Vendedor WHERE IdVendedor=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            if (rs.next()) {
                v.setIdVendedor(rs.getInt(1));
                v.setNombre(rs.getString(2));
                v.setApellido(rs.getString(3));
                v.setTelefono(rs.getInt(4));
                v.setDNI(rs.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return v;
    }

    @Override
    public List<Vendedor> readAll() {
        List<Vendedor> lista = new ArrayList<>();
        String SQL = "SELECT * FROM Vendedor";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vendedor v = new Vendedor();
                v.setIdVendedor(rs.getInt(1));
                v.setNombre(rs.getString(2));
                v.setApellido(rs.getString(3));
                v.setTelefono(rs.getInt(4));
                v.setDNI(rs.getInt(5));
                v.setIdUsuario(rs.getInt(6));
                lista.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    @Override
    public Vendedor Buscador(int index) {
        Vendedor v = new Vendedor();
        String SQL = "SELECT * FROM Vendedor WHERE IdVendedor=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            if (rs.next()) {
                v.setNombre(rs.getString("Nombre"));
                v.setApellido(rs.getString("Apellido"));
                v.setTelefono(rs.getInt("Telefono"));
                v.setDNI(rs.getInt("DNI"));
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
    public List<Vendedor> readAllDisponible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
