
package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.EstatisticasDao;
import model.dao.TipoDeMidiaDao;
import model.database.DB;
import model.database.DbException;
import model.entity.TipoDeMidia;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public class EstatisticasDaoJDBC implements EstatisticasDao {
    
    Connection conn;

    public EstatisticasDaoJDBC(Connection connection) {
        this.conn = connection;
    }

    @Override
    public int getAlbunsOuvidos() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(" SELECT COUNT(*) FROM Album WHERE status = 1; ");
            rs = st.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException ex){
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public int getQtdeMidia(int tipoDeMidia) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(" SELECT COUNT(*) FROM MidiasDisponiveis WHERE TipoDeMidia_id = ?; ");
            st.setInt(1, tipoDeMidia);
            rs = st.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException ex){
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public int getTotalDeMidias() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(" SELECT COUNT(*) FROM MidiasDisponiveis; ");
            rs = st.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException ex){
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
    
    @Override
    public int getTotalDeAlbuns() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(" SELECT COUNT(*) FROM Album; ");
            rs = st.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException ex){
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

}
