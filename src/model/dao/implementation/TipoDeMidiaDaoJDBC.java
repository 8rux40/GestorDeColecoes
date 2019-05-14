package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.TipoDeMidiaDao;
import model.database.DB;
import model.database.DbException;
import model.entity.Album;
import model.entity.TipoDeMidia;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public class TipoDeMidiaDaoJDBC implements TipoDeMidiaDao {

    private Connection conn;

    public TipoDeMidiaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public TipoDeMidia findById(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                "SELECT * FROM TipoDeMidia "
                + "WHERE id = ?"
            );
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                TipoDeMidia tdm = instantiateTipoDeMidia(rs);
                return tdm;
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
    public List<TipoDeMidia> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(" SELECT * FROM TipoDeMidia; ");
            rs = st.executeQuery();
            List<TipoDeMidia> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(instantiateTipoDeMidia(rs));
            }
            return lista;
        } catch (SQLException ex){
            throw new DbException(ex.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
    
    protected static TipoDeMidia instantiateTipoDeMidia(ResultSet rs) throws SQLException {
        return new TipoDeMidia(
            rs.getInt("id"),
            rs.getString("descricao")
        );
    }
}
