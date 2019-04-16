package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 8rux40 
 * @github https://github.com/8rux40
 */
public class NovoAlbumController implements Initializable {

    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtArtista;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onBtnUploadAction(ActionEvent event) {
    }

    @FXML
    private void onBtnConfirmarAction(ActionEvent event) {
    }

    @FXML
    private void onBtnCancelarAction(ActionEvent event) {
    }
    
}
