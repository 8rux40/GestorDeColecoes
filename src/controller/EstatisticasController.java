package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import model.entity.Estatisticas;

/**
 * FXML Controller class
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public class EstatisticasController implements Initializable {

    @FXML
    private PieChart grafico;
    @FXML
    private Label lblTotalAlbuns;
    @FXML
    private Label lblOuvidos;
    @FXML
    private Label lblTotalCD;
    @FXML
    private Label lblTotalDVD;
    @FXML
    private Label lblTotalBluray;
    @FXML
    private Label lblTotalVinil;
    @FXML
    private Label lblTotalK7;
    @FXML
    private Label lblTotalMidias;
    @FXML
    private ProgressBar pbAlbunsOuvidos;
    @FXML
    private Label lblAlbunsOuvidos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Estatisticas e = new Estatisticas();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("CD", e.getPorcentagemCd()),
            new PieChart.Data("DVD", e.getPorcentagemDvd()),
            new PieChart.Data("Vinil", e.getPorcentagemVinil()),
            new PieChart.Data("BluRay", e.getPorcentagemBluray()),
            new PieChart.Data("K7", e.getPorcentagemK7())
        );
        grafico.setData(pieChartData);
        lblTotalVinil.setText(String.format("%d",e.getTotalVinil()));
        lblTotalCD.setText(String.format("%d",e.getTotalCd()));
        lblTotalDVD.setText(String.format("%d",e.getTotalDvd()));
        lblTotalK7.setText(String.format("%d",e.getTotalK7()));
        lblTotalBluray.setText(String.format("%d",e.getTotalBluray()));
        lblTotalMidias.setText(String.format("%d",e.getTotalMidias()));
        lblTotalAlbuns.setText(String.format("%d",e.getTotalAlbuns()));
        lblOuvidos.setText(String.format("%d",e.getTotalOuvidos()));
        
        double porcentagemAlbunsOuvidos = e.getPorcentagemAlbunsOuvidos();
        pbAlbunsOuvidos.setProgress(porcentagemAlbunsOuvidos);
        lblAlbunsOuvidos.setText(String.format("%.1f%c",porcentagemAlbunsOuvidos*100.0,'%'));
        
        
    }    

    
}
