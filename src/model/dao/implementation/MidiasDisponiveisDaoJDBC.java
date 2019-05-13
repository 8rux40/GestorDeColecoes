package model.dao.implementation;

import java.sql.Connection;
import java.util.List;
import model.dao.MidiasDisponiveisDao;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(MidiasDisponiveis md) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(MidiasDisponiveis md) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoDeMidia> findTipoDeMidiaByAlbum(Album a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Album> findAlbumByTipoDeMidia(TipoDeMidia tdm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
