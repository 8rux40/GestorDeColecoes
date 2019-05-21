package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import model.dao.AlbumDao;
import model.dao.DaoFactory;
import model.entity.Album;
import model.util.AlbumListCell;

/**
 * FXML Controller class
 *
 * @author 8rux40
 * @github https://github.com/8rux40
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
    private static Button btnNovoAlbum;
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
    @FXML
    private ListView<Album> lvAlbuns;
    
    private static Album albumSelecionado;
    @FXML
    private Button btnEstatisticas;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gerarItensDaLista();
    }    
    
    private void gerarItensDaLista(){
        lvAlbuns.getItems().clear();
        lvAlbuns.setCellFactory(param -> new AlbumListCell());
        lvAlbuns.setPrefHeight(180);
        lvAlbuns.getItems().setAll(carregaListaAlbuns());
        lvAlbuns.refresh();
    }
    
    
    private List<Album> carregaListaAlbuns(){
        /*
            PEGAR LISTA DE ALBUNS CADASTRADOS DO BD
        */
        return DaoFactory.createAlbumDao().findAll();
    }
    
    public static void removerAlbum(Album a){
        /*
            REMOVER ALBUM DAO
        */
        DaoFactory.createAlbumDao().delete(a);
    }
    
    public void editarAlbum(Album a){
        try {
            /*
            Abre tela de edição
            */
//        Util.chamarTela(btnNovoAlbum.getClass().getResource("/view/EditarAlbum.fxml"));
            FXMLLoader loader = new FXMLLoader(btnNovoAlbum.getClass().getResource("/view/EditarAlbum.fxml"));
            Stage stage = new Stage();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent t) {
                    JOptionPane.showMessageDialog(null, "Funcionando");
                    gerarItensDaLista();
                }
            });
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
            stage.show();
            JOptionPane.showMessageDialog(null, "testse");
            lvAlbuns.getItems().setAll(carregaListaAlbuns());
        } catch (IOException ex) {
            Logger.getLogger(TestefxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void novoAlbum(){
        Util.chamarTela(getClass().getResource("/view/NovoAlbum.fxml"));
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
        gerarItensDaLista();
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

    @FXML
    private void onBtnNovoAlbumAction(ActionEvent event) {
        novoAlbum();
    }

    @FXML
    private void onBtnEstatisticasAction(ActionEvent event) {
        Util.chamarTela(getClass().getResource("/view/Estatisticas.fxml"));
    }
    
}
