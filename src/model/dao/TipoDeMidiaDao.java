package model.dao;

import java.util.List;
import model.entity.TipoDeMidia;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public interface TipoDeMidiaDao {
    /**
     * Os tipos de mídia não mudarão, portanto, não existem outros métodos
     * além do SELECT
     */
    public TipoDeMidia findById(int id);
    public List<TipoDeMidia> findAll();
}
