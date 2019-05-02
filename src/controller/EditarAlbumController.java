package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.entity.Album;
import model.util.AlbumListCell;

/**
 * FXML Controller class
 *
 * @author 8rux40 
 * @github https://github.com/8rux40
 */
public class EditarAlbumController implements Initializable {

    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtArtista;
    @FXML
    private ImageView capa;
    @FXML
    private Button btnUpload;
    @FXML
    private CheckBox cbCd;
    @FXML
    private CheckBox cbDvd;
    @FXML
    private CheckBox cbVinil;
    @FXML
    private CheckBox cbBluray;
    @FXML
    private CheckBox cbK7;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtAno;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Album a = AlbumListCell.getAlbumSelecionado();
        if (a != null) {
            preencheInformacoes(a);
        }
    }    
    
    private void preencheInformacoes(Album a){
        txtArtista.setText(a.getArtista());
        txtTitulo.setText(a.getTitulo());
        txtAno.setText(String.format("%d", a.getAnoLancamento()));
        for (Integer midia : a.getMidiasDisponiveis()){
            switch(midia){
                case Album.CD:{
                    cbCd.setSelected(true);
                } break;
                case Album.DVD:{
                    cbDvd.setSelected(true);
                } break;
                case Album.BluRay:{
                    cbBluray.setSelected(true);
                } break;
                case Album.Vinil:{
                    cbVinil.setSelected(true);
                } break;
                case Album.K7:{
                    cbK7.setSelected(true);
                } break;
            }
        }
        capa.setImage(a.getCapa());
    }

    @FXML
    private void onBtnUploadAction(ActionEvent event) {
    }

    @FXML
    private void onBtnConfirmarAction(ActionEvent event) {
    }

    @FXML
    private void onBtnCancelarAction(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    
}
