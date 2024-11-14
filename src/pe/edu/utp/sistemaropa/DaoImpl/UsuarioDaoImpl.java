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
import pe.edu.utp.sistemaropa.dto.Usuario;
/**
 *
 * @author Nayely
 */
public class UsuarioDaoImpl implements Operaciones<Usuario> {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conex;

    @Override
    public int create(Usuario u) {
        int y = 0;
        String SQL = "INSERT INTO Usuario(Rol, Contraseña) VALUES(?, ?)";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, u.getRol());
            ps.setString(2, u.getContraseña());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int update(Usuario u) {
        int y = 0;
        String SQL = "UPDATE Usuario SET Rol=?, Contraseña=? WHERE IdUsuario=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, u.getRol());
            ps.setString(2, u.getContraseña());
            ps.setInt(3, u.getIdUsuario());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int delete(int index) {
        int y = 0;
        String SQL = "DELETE FROM Usuario WHERE IdUsuario=?";
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
    public Usuario read(int index) {
        Usuario u = new Usuario();
        String SQL = "SELECT * FROM Usuario WHERE IdUsuario=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            if (rs.next()) {
                u.setIdUsuario(rs.getInt(1));
                u.setRol(rs.getString(2));
                u.setContraseña(rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return u;
    }

    @Override
    public List<Usuario> readAll() {
        List<Usuario> lista = new ArrayList<>();
        String SQL = "SELECT * FROM Usuario";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt(1));
                u.setRol(rs.getString(2));
                u.setContraseña(rs.getString(3));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    @Override
    public List<Usuario> readAllDisponible() {
        List<Usuario> lista = new ArrayList<>();
        String SQL = "SELECT "
                + "    u.IdUsuario, "
                + "    u.Rol, "
                + "    CASE "
                + "        WHEN v.IdUsuario IS NOT NULL OR a.IdUsuario IS NOT NULL THEN 'No Disponible' "
                + "        ELSE 'Disponible' "
                + "    END AS Disponible "
                + "FROM Usuario u "
                + "LEFT JOIN Vendedor v ON u.IdUsuario = v.IdUsuario "
                + "LEFT JOIN Administrador a ON u.IdUsuario = a.IdUsuario";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("IdUsuario"));
                u.setRol(rs.getString("Rol"));
                u.setDisponible(rs.getString("Disponible"));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    @Override
    public Usuario Buscador(int index) {
        Usuario u = new Usuario();
        String SQL = "SELECT * FROM Usuario WHERE IdUsuario=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            if (rs.next()) {
                u.setRol(rs.getString("Rol"));
                u.setContraseña(rs.getString("Contraseña"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return u;
    }

    public Usuario log(String usuario, String pass) {

        Usuario u = new Usuario();
        String SQL = "SELECT * FROM usuario WHERE Rol = ? AND Contraseña = ?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);

            ps.setString(1, u.getRol());
            ps.setString(2, u.getContraseña());

            rs = ps.executeQuery();
            if (rs.next()) {

                u.setRol(rs.getString("rol"));
                u.setContraseña(rs.getString("Contraseña"));

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return u;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
