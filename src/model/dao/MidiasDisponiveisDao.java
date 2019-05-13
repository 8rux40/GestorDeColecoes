package model.dao;

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
    public void update(MidiasDisponiveis md);
    public void delete(MidiasDisponiveis md);
    public void deleteById(int id);
    public void findByAlbum(Album a);
    public void findByTipoDeMidia(TipoDeMidia tdm);
    public void findAll();
}
