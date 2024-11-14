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
import pe.edu.utp.sistemaropa.dto.Producto;
/**
 *
 * @author Nayely
 */
public class ProductoDaoImpl implements Operaciones<Producto> {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conex;

    @Override
    public int create(Producto t) {
        int y = 0;
        String SQL = "INSERT INTO Producto(Nombre, Stock, Precio, IdProveedor) VALUES(?, ?, ?, ?)";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getStock());
            ps.setDouble(3, t.getPrecio());
            ps.setInt(4, t.getIdproveedor());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int update(Producto t) {
        int y = 0;
        String SQL = "UPDATE Producto SET Nombre=?, Stock=?, Precio=?, IdProveedor=?  WHERE IdProducto=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getStock());
            ps.setDouble(3, t.getPrecio());
            ps.setInt(4, t.getIdproveedor());
            ps.setInt(5, t.getIdproducto());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int delete(int index) {
        int y = 0;
        String SQL = "DELETE FROM Producto WHERE IdProducto=?";
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
    public Producto read(int index) {
        Producto c = new Producto();
        String SQL = "SELECT * FROM Producto WHERE IdProducto=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdproducto(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setStock(rs.getInt(3));
                c.setPrecio(rs.getDouble(4));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return c;
    }

    @Override
    public List<Producto> readAll() {
        List<Producto> lista = new ArrayList<>();
        String SQL = "SELECT * FROM Producto";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto t = new Producto();
                t.setIdproducto(rs.getInt(1));
                t.setNombre(rs.getString(2));
                t.setPrecio(rs.getDouble(3));
                t.setStock(rs.getInt(4));
                t.setIdproveedor(rs.getInt(5));
                lista.add(t);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    @Override
    public Producto Buscador(int index) {
        Producto cl = new Producto();
        String SQL = "SELECT * FROM Producto WHERE IdProducto=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            if (rs.next()) {
                cl.setNombre(rs.getString("DNI"));
                cl.setStock(rs.getInt("Nombre"));
                cl.setPrecio(rs.getDouble("Apellido"));
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
    public List<Producto> readAllDisponible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
