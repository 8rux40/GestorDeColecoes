package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.dao.AlbumDao;
import model.dao.DaoFactory;
import model.dao.MidiasDisponiveisDao;
import model.dao.TipoDeMidiaDao;
import model.database.DB;
import model.database.DbException;
import model.entity.Album;
import model.entity.MidiasDisponiveis;
import model.entity.TipoDeMidia;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public class MidiasDisponiveisDaoJDBC implements MidiasDisponiveisDao{
    
    private Connection conn;
    
    public MidiasDisponiveisDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(MidiasDisponiveis md) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                "INSERT INTO MidiasDisponiveis "
                + " (Album_id, TipoDeMidia_id)"
                + "VALUES (?,?); ",
                Statement.RETURN_GENERATED_KEYS
            );
            st.setInt(1, md.getAlbum().getId());
            st.setInt(2, md.getTipoDeMidia().getId());
            
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
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
    public void delete(MidiasDisponiveis md) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                " DELETE FROM MidiasDisponiveis WHERE Album_id = ? AND TipoDeMidia_id = ?; "
            );
            st.setInt(1, md.getAlbum().getId());
            st.setInt(2, md.getTipoDeMidia().getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<TipoDeMidia> findTipoDeMidiaByAlbum(Album a) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(" SELECT * FROM MidiasDisponiveis WHERE Album_id = ?; ");
            st.setInt(1, a.getId());
            rs = st.executeQuery();
            List<TipoDeMidia> lista = new ArrayList<>();
            while(rs.next()){
                TipoDeMidiaDao tdmDao = DaoFactory.createTipoDeMidiaDao();
                TipoDeMidia tdm = tdmDao.findById(rs.getInt("TipoDeMidia_id"));
                if (tdm != null) {
                    lista.add(tdm);
                }
            }
            return lista;
        } catch (SQLException ex){
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Album> findAlbumByTipoDeMidia(TipoDeMidia tdm) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(" SELECT * FROM MidiasDisponiveis WHERE TipoDeMidia_id = ?; ");
            st.setInt(1, tdm.getId());
            rs = st.executeQuery();
            List<Album> lista = new ArrayList<>();
            while(rs.next()){
                AlbumDao aDao = DaoFactory.createAlbumDao();
                Album a = aDao.findById(rs.getInt("Album_id"));
                if (a != null) {
                    lista.add(a);
                }
            }
            return lista;
        } catch (SQLException ex){
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

}
