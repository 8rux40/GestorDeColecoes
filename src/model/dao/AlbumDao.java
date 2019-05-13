package model.dao;

import java.util.List;
import model.entity.Album;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public interface AlbumDao {
    public void insert(Album album);
    public void update(Album album);
    public void delete(Album album);
    public void deleteById(int id);
    public Album findById(int id);
    public List<Album> findAll();
}
