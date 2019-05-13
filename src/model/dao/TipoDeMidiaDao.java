package model.dao;

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
    public void findById(int id);
    public void findAll();
}
