/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import pe.edu.utp.sistemaropa.dto.Administrador;

public class AdministradorDaoImpl implements Operaciones<Administrador> {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conex;

    @Override
    public int create(Administrador t) {
        int y = 0;
        String SQL = "INSERT INTO Administrador(Nombre, Apellido, Telefono, Dni, IdUsuario) VALUES (?, ?, ?, ?, ?)";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getApellido());
            ps.setInt(3, t.getTelefono());
            ps.setInt(4, t.getDNI());
            ps.setInt(5, t.getIdUsuario());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return y;
    }

    @Override
    public int update(Administrador t) {
        int y = 0;
        String SQL = "UPDATE Administrador SET Nombre=?, Apellido=?, Telefono=?, Dni=? WHERE IdAdministrador=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getApellido());
            ps.setInt(3, t.getTelefono());
            ps.setInt(4, t.getDNI());
            ps.setInt(5, t.getIdAdministrador());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return y;
    }

    @Override
    public int delete(int index) {
        int y = 0;
        String SQL = "DELETE FROM Administrador WHERE IdAdministrador=?";
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
    public Administrador read(int index) {
        Administrador ad = new Administrador();
        String SQL = "SELECT * FROM Administrador WHERE IdAdministrador=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                ad.setIdAdministrador(rs.getInt(1));
                ad.setNombre(rs.getString(2));
                ad.setApellido(rs.getString(3));
                ad.setTelefono(rs.getInt(3));
                ad.setDNI(rs.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return ad;
    }

    @Override
    public List<Administrador> readAll() {
        List<Administrador> lista1 = new ArrayList<>();
        String SQL = "SELECT * FROM Administrador";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Administrador t = new Administrador();
                t.setIdAdministrador(rs.getInt(1));
                t.setNombre(rs.getString(2));
                t.setApellido(rs.getString(3));
                t.setTelefono(rs.getInt(3));
                t.setDNI(rs.getInt(4));
                lista1.add(t);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista1;
    }

    @Override
    public Administrador Buscador(int index) {
        Administrador cl = new Administrador();
        String SQL = "SELECT * FROM Administrador WHERE IdAdministrador=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            if (rs.next()) {
                cl.setNombre(rs.getString("Nombre"));
                cl.setApellido(rs.getString("Apellido"));
                cl.setTelefono(rs.getInt("Telefono"));
                cl.setDNI(rs.getInt("DNI"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return cl;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Administrador> readAllDisponible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
