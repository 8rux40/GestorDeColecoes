package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Grapefruit", 13),
            new PieChart.Data("Oranges", 25),
            new PieChart.Data("Plums", 10),
            new PieChart.Data("Pears", 22),
            new PieChart.Data("Apples", 30)
        );
        grafico.setData(pieChartData);
    }    

    
}
