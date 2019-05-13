package model.dao;

import model.dao.implementation.AlbumDaoJDBC;
import model.dao.implementation.MidiasDisponiveisDaoJDBC;
import model.dao.implementation.TipoDeMidiaDaoJDBC;
import model.database.DB;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public class DaoFactory {

    public static AlbumDao createAlbumDao() {
        return new AlbumDaoJDBC(DB.getConnection());
    }
    
    public static TipoDeMidiaDao createTipoDeMidiaDao(){
        return new TipoDeMidiaDaoJDBC(DB.getConnection());
    }
    
    public static MidiasDisponiveisDao createMidiasDisponiveisDao(){
        return new MidiasDisponiveisDaoJDBC(DB.getConnection());
    }
}
