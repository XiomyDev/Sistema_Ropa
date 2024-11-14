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
import pe.edu.utp.sistemaropa.dto.Cliente;
/**
 *
 * @author Nayely
 */
public class ClienteDaoImpl implements Operaciones<Cliente> {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conex;

    @Override
    public int create(Cliente t) {
        int y = 0;
        String SQL = "INSERT INTO Cliente(Dni, Nombre, Apellido, Telefono, Direccion, Ruc) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, t.getDni());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellido());
            ps.setInt(4, t.getTelefono());
            ps.setString(5, t.getDireccion());
            ps.setString(6, t.getRuc());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int update(Cliente t) {
        int y = 0;
        String SQL = "UPDATE Cliente SET Dni=?, Nombre=?, Apellido=?, Telefono=?, Direccion=?, Ruc=? WHERE IdCliente=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, t.getDni());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellido());
            ps.setInt(4, t.getTelefono());
            ps.setString(5, t.getDireccion());
            ps.setString(6, t.getRuc());
            ps.setInt(7, t.getIdcliente());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int delete(int index) {
        int y = 0;
        String SQL = "DELETE FROM Cliente WHERE IdCliente=?";
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
    public Cliente read(int index) {
        Cliente c = new Cliente();
        String SQL = "SELECT * FROM Cliente WHERE IdCliente=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdcliente(rs.getInt(1));
                c.setDni(rs.getInt(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setTelefono(rs.getInt(5));
                c.setDireccion(rs.getString(6));
                c.setRuc(rs.getString(7));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return c;
    }

    @Override
    public List<Cliente> readAll() {
        List<Cliente> lista = new ArrayList<>();
        String SQL = "SELECT * FROM Cliente";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente t = new Cliente();
                t.setIdcliente(rs.getInt(1));
                t.setDni(rs.getInt(2));
                t.setNombre(rs.getString(3));
                t.setApellido(rs.getString(4));
                t.setTelefono(rs.getInt(5));
                t.setDireccion(rs.getString(6));
                t.setRuc(rs.getString(7));
                lista.add(t);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    @Override
    public Cliente Buscador(int index) {
        Cliente cl = new Cliente();
        String SQL = "SELECT * FROM cliente WHERE IdCliente=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            if (rs.next()) {
                cl.setDni(rs.getInt("DNI"));
                cl.setNombre(rs.getString("Nombre"));
                cl.setApellido(rs.getString("Apellido"));
                cl.setTelefono(rs.getInt("Telefono"));
                cl.setDireccion(rs.getString("Direccion"));
                cl.setRuc(rs.getString("RUC"));
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
    public List<Cliente> readAllDisponible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
