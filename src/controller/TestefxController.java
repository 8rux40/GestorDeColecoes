package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 8rux40
 */
public class TestefxController implements Initializable {
    @FXML
    private BorderPane borderPaneMain;
    @FXML
    private Pane topPane;
    @FXML
    private RadioButton rbTodas;
    @FXML
    private ToggleGroup midia;
    @FXML
    private RadioButton rbOutra;
    @FXML
    private CheckBox cbCd;
    @FXML
    private Button btnNovoAlbum;
    @FXML
    private CheckBox cbDvd;
    @FXML
    private CheckBox cbVinil;
    @FXML
    private CheckBox cbBluray;
    @FXML
    private CheckBox cbK7;
    @FXML
    private Pane leftPane;
    @FXML
    private ScrollPane scrollAlbuns;
    @FXML
    private AnchorPane anchorAlbuns;
    @FXML
    private Pane rightPane;
    @FXML
    private Label filtroTodas;
    @FXML
    private Label filtroCd;
    @FXML
    private Label filtroDvd;
    @FXML
    private Label filtroVinil;
    @FXML
    private Label filtroBluray;
    @FXML
    private Label filtroK7;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void removerAlbum(){
        
    }
    
    private void editarAlbum(){
        
    }
    
    private void novoAlbum(){
        
    }
    
    private void ativaDesativaFiltro(CheckBox cbFiltro, Label filtroLbl){
        boolean status = cbFiltro.isSelected();
        if (!status) {
            rbOutra.setSelected(true);
            ativaDesativaFiltro(false, filtroTodas);
        }
        cbFiltro.setSelected(!status);
        ativaDesativaFiltro(!status, filtroLbl);
    }
    
    private void ativaDesativaFiltro(boolean status, Label filtroLbl){
        if(!status){
            filtroLbl.getStyleClass().remove("etiqueta-grande-selecionada");
            filtroLbl.getStyleClass().add("etiqueta-grande");
        } else {
            filtroLbl.getStyleClass().remove("etiqueta-grande");
            filtroLbl.getStyleClass().add("etiqueta-grande-selecionada");
        }
    }  
    
    private void desativaFiltros(){
        cbCd.setSelected(false);
        cbDvd.setSelected(false);
        cbVinil.setSelected(false);
        cbBluray.setSelected(false);
        cbK7.setSelected(false);
        ativaDesativaFiltro(false, filtroCd);
        ativaDesativaFiltro(false, filtroDvd);
        ativaDesativaFiltro(false, filtroVinil);
        ativaDesativaFiltro(false, filtroBluray);
        ativaDesativaFiltro(false, filtroK7);
    }

    @FXML
    private void onFiltroTodasClicked(MouseEvent event) {
        rbTodas.setSelected(true);
        ativaDesativaFiltro(true, filtroTodas);
        desativaFiltros();
    }

    @FXML
    private void onFiltroCdClicked(MouseEvent event) {
        ativaDesativaFiltro(cbCd, filtroCd);
    }

    @FXML
    private void onFiltroDvdClicked(MouseEvent event) {
        ativaDesativaFiltro(cbDvd, filtroDvd);
    }

    @FXML
    private void onFiltroVinilClicked(MouseEvent event) {
        ativaDesativaFiltro(cbVinil, filtroVinil);
    }

    @FXML
    private void onFiltroBlurayClicked(MouseEvent event) {
        ativaDesativaFiltro(cbBluray, filtroBluray);
    }

    @FXML
    private void onFiltroK7Clicked(MouseEvent event) {
        ativaDesativaFiltro(cbK7, filtroK7);
    }
    
}
