package model.dao;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public interface EstatisticasDao {
    public int getAlbunsOuvidos();
    public int getQtdeMidia(int tipoDeMidia);
    public int getTotalDeMidias();
    public int getTotalDeAlbuns();
}
