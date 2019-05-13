package model.dao.implementation;

import java.sql.Connection;
import model.dao.TipoDeMidiaDao;

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
    public void findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
