package model.dao.implementation;

import java.sql.Connection;
import java.util.List;
import model.dao.AlbumDao;
import model.entity.Album;

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
    public void insert(Album album) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Album album) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Album album) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Album findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Album> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
