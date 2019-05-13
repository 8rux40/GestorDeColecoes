package model.dao.implementation;

import java.sql.Connection;
import java.util.List;
import model.dao.TipoDeMidiaDao;
import model.entity.TipoDeMidia;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public class TipoDeMidiaDaoJDBC implements TipoDeMidiaDao{

    private Connection conn;
    
    public TipoDeMidiaDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public TipoDeMidia findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoDeMidia> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
