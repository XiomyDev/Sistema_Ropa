package pe.edu.utp.sistemaropa.DaoImpl;
/**
 *
 * @author Nayely
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pe.edu.utp.sistemaropa.config.Conexion;
import pe.edu.utp.sistemaropa.dao.Operaciones;
import pe.edu.utp.sistemaropa.dto.Proveedor;
/**
 *
 * @author Nayely
 */
public class ProveedorDaoImpl implements Operaciones<Proveedor> {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conex;

    @Override
    public int create(Proveedor t) {
        int y = 0;
        String SQL = "INSERT INTO Proveedor(Nombre, Telefono, Direccion, Razon, Ruc, IdAdministrador) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getTelefono());
            ps.setString(3, t.getDireccion());
            ps.setString(4, t.getRazon());
            ps.setString(5, t.getRuc());
            ps.setInt(6, t.getIdAdministrador());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int update(Proveedor t) {
        int y = 0;
        String SQL = "UPDATE Proveedor SET Nombre=?, Telefono=?, Direccion=?, Ruc=?, IdAdministrador=? WHERE IdProveedor=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getTelefono());
            ps.setString(3, t.getDireccion());
            ps.setString(4, t.getRuc());
            ps.setInt(5, t.getIdProveedor());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int delete(int index) {
        int y = 0;
        String SQL = "DELETE FROM Proveedor WHERE IdProveedor=?";
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
    public Proveedor read(int index) {
        Proveedor c = new Proveedor();
        String SQL = "SELECT * FROM Proveedor WHERE IdProveedor=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdProveedor(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setTelefono(rs.getInt(3));
                c.setDireccion(rs.getString(4));
                c.setRazon(rs.getString(5));
                c.setRuc(rs.getString(6));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return c;
    }

    @Override
    public List<Proveedor> readAll() {
        List<Proveedor> lista = new ArrayList<>();
        String SQL = "SELECT * FROM Proveedor";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor c = new Proveedor();
                c.setIdProveedor(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setTelefono(rs.getInt(3));
                c.setDireccion(rs.getString(4));
                c.setRazon(rs.getString(5));
                c.setRuc(rs.getString(6));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    @Override
    public Proveedor Buscador(int index) {
        Proveedor cl = new Proveedor();
        String SQL = "SELECT * FROM Proveedor WHERE IdProveedor=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            if (rs.next()) {
                cl.setNombre(rs.getString("Nombre"));
                cl.setTelefono(rs.getInt("Telefono"));
                cl.setDireccion(rs.getString("Direccion"));
                cl.setRazon(rs.getString("Razon"));
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
    public List<Proveedor> readAllDisponible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
