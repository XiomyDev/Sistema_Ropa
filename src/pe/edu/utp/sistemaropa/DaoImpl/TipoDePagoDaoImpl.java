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
import pe.edu.utp.sistemaropa.dto.TipoDePago;
/**
 *
 * @author Nayely
 */

public class TipoDePagoDaoImpl implements Operaciones<TipoDePago> {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conex;

    @Override
    public int create(TipoDePago t) {
        int y = 0;
        String SQL = "INSERT INTO TipoDePago(NombreTipoDePago) VALUES(?)";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, t.getNombreTipoDePago());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int update(TipoDePago t) {
        int y = 0;
        String SQL = "UPDATE TipoDePago SET NombreTipoDePago=? WHERE IdTipoDePago=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setString(1, t.getNombreTipoDePago());
            ps.setInt(2, t.getIdTipoDePago());
            y = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return y;
    }

    @Override
    public int delete(int index) {
        int y = 0;
        String SQL = "DELETE FROM TipoDePago WHERE IdTipoDePago=?";
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
    public TipoDePago read(int index) {
        TipoDePago t = new TipoDePago();
        String SQL = "SELECT * FROM TipoDePago WHERE IdTipoDePago=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            if (rs.next()) {
                t.setIdTipoDePago(rs.getInt(1));
                t.setNombreTipoDePago(rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return t;
    }

    @Override
    public List<TipoDePago> readAll() {
        List<TipoDePago> lista = new ArrayList<>();
        String SQL = "SELECT * FROM TipoDePago";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoDePago t = new TipoDePago();
                t.setIdTipoDePago(rs.getInt(1));
                t.setNombreTipoDePago(rs.getString(2));
                lista.add(t);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    @Override
    public TipoDePago Buscador(int index) {
        TipoDePago t = new TipoDePago();
        String SQL = "SELECT * FROM TipoDePago WHERE IdTipoDePago=?";
        try {
            conex = Conexion.getConexion();
            ps = conex.prepareStatement(SQL);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            if (rs.next()) {
                t.setNombreTipoDePago(rs.getString("TipoDePago"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return t;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TipoDePago> readAllDisponible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
