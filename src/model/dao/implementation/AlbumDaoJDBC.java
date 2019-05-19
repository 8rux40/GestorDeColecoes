package model.dao.implementation;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import model.dao.AlbumDao;
import static model.dao.implementation.TipoDeMidiaDaoJDBC.instantiateTipoDeMidia;
import model.database.DB;
import model.database.DbException;
import model.entity.Album;
import model.entity.TipoDeMidia;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public class AlbumDaoJDBC implements AlbumDao{
    
    private Connection conn;
    
    public AlbumDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Album a) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                "INSERT INTO Album "
                + " (titulo, artista, anoLancamento, capa, status)"
                + "VALUES (?,?,?,?,?); ",
                Statement.RETURN_GENERATED_KEYS
            );
            System.out.println("DAO Path: "+a.getCapa().getPath());
            System.out.println("DAO Absolute: "+a.getCapa().getAbsolutePath());
            st.setString(1, a.getTitulo());
            st.setString(2, a.getArtista());
            st.setString(4, a.getCapa().getPath());
            st.setInt(3, a.getAnoLancamento());
            st.setInt(5, a.getStatus());
            
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()){
                    int id = rs.getInt(1);
                    a.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Erro inesperado, nenhuma linha afetada!\n");
            }
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Album a) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                "UPDATE Album "
                + " SET titulo = ?, artista = ?, anoLancamento = ?, capa = ?, status = ?"
                + " WHERE (id = ?); "
            );
            st.setString(1, a.getTitulo());
            st.setString(2, a.getArtista());
            st.setString(4, a.getCapa().getPath());
            st.setInt(3, a.getAnoLancamento());
            st.setInt(5, a.getStatus());
            st.setInt(6, a.getId());
            
            st.executeUpdate();
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void delete(Album a) {
        deleteById(a.getId());
    }

    @Override
    public void deleteById(int id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                " DELETE FROM Album WHERE id = ?; "
            );
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Album findById(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                "SELECT * FROM Album "
                + "WHERE id = ?"
            );
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Album obj = instantiateAlbum(rs);
                return obj;
            }
            return null;
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Album> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(" SELECT * FROM Album; ");
            rs = st.executeQuery();
            List<Album> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(instantiateAlbum(rs));
            }
            return lista;
        } catch (SQLException ex){
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    protected static Album instantiateAlbum(ResultSet rs) throws SQLException {
        return new Album(
            rs.getInt("id"),
            rs.getString("titulo"),
            rs.getString("artista"),
            rs.getInt("anoLancamento"),
            new File(rs.getString("capa")),
            rs.getInt("status")
        );
    }
    
}
