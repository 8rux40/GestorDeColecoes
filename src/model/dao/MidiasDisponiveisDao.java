package model.dao;

import java.util.List;
import model.entity.Album;
import model.entity.MidiasDisponiveis;
import model.entity.TipoDeMidia;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public interface MidiasDisponiveisDao {
    public void insert(MidiasDisponiveis md);
    public void delete(MidiasDisponiveis md);
    public void deleteAllByAlbum(Album a);
    public List<TipoDeMidia> findTipoDeMidiaByAlbum(Album a);
    public List<Album> findAlbumByTipoDeMidia(TipoDeMidia tdm);
}
