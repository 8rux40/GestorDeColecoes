package model.entity;

import model.dao.DaoFactory;
import model.dao.EstatisticasDao;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public class Estatisticas {
    private int totalCd;
    private int totalDvd;
    private int totalBluray;
    private int totalVinil;
    private int totalK7;
    private int totalMidias;
    private int totalAlbuns;
    private int totalOuvidos;
    
    public Estatisticas(){
        EstatisticasDao dao = DaoFactory.createEstatisticasDao();
        totalCd = dao.getQtdeMidia(TipoDeMidia.CD);
        totalDvd = dao.getQtdeMidia(TipoDeMidia.DVD);
        totalBluray = dao.getQtdeMidia(TipoDeMidia.BluRay);
        totalVinil = dao.getQtdeMidia(TipoDeMidia.Vinil);
        totalK7 = dao.getQtdeMidia(TipoDeMidia.K7);
        totalMidias = dao.getTotalDeMidias();
        totalAlbuns = dao.getTotalDeAlbuns();
        totalOuvidos = dao.getAlbunsOuvidos();
    }

    public int getTotalCd() {
        return totalCd;
    }

    public int getTotalDvd() {
        return totalDvd;
    }

    public int getTotalBluray() {
        return totalBluray;
    }

    public int getTotalVinil() {
        return totalVinil;
    }

    public int getTotalK7() {
        return totalK7;
    }

    public int getTotalMidias() {
        return totalMidias;
    }

    public int getTotalAlbuns() {
        return totalAlbuns;
    }

    public int getTotalOuvidos() {
        return totalOuvidos;
    }
    
    public double getPorcentagemCd(){
        return (totalCd * 100.0 / totalMidias);
    }
    
    public double getPorcentagemDvd(){
        return (totalDvd * 100.0 / totalMidias);
    }
    
    public double getPorcentagemBluray(){
        return (totalBluray * 100.0 / totalMidias);
    }
    
    public double getPorcentagemVinil(){
        return (totalVinil * 100.0 / totalMidias);
    }
    
    public double getPorcentagemK7(){
        return (totalK7 * 100.0 / totalMidias);
    }
    
    public double getPorcentagemAlbunsOuvidos(){
        return (totalOuvidos * 1.0 / totalAlbuns);
    }
}
