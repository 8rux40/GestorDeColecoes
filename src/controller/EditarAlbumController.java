package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
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
    
    private void atualizaCapaAtual(File f){
        Image img;
        try {
            System.out.println(f.getCanonicalPath());
        } catch (IOException ex) {
            Logger.getLogger(EditarAlbumController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            img = new Image(new FileInputStream(f.getAbsolutePath()));
            capa.setImage(img);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EditarAlbumController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Album getAlbumAtualizado(){
        Album a = null;
        try {
            a = new Album();
            a.setArtista(txtArtista.getText());
            a.setAnoLancamento(Integer.parseInt(txtAno.getText()));
            a.setTitulo(a.getTitulo());
            
            List<Integer> midias = new ArrayList<>();
            if (cbCd.isSelected()) midias.add(Album.CD);
            if (cbDvd.isSelected()) midias.add(Album.DVD);
            if (cbBluray.isSelected()) midias.add(Album.BluRay);
            if (cbVinil.isSelected()) midias.add(Album.Vinil);
            if (cbK7.isSelected()) midias.add(Album.K7);
            a.setMidiasDisponiveis(midias);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            return a;
        }
    }

    @FXML
    private void onBtnUploadAction(ActionEvent event) {
        /*
            CAIXA DE DIALOGO PARA TROCAR A IMAGEM DE CAPA
        */
        FileChooser fc = new FileChooser();
        fc.setTitle("Escolha uma nova imagem para ser capa do Álbum");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("JPG", "*.jpg"),
            new FileChooser.ExtensionFilter("PNG", "*.png"),
            new FileChooser.ExtensionFilter("JPEG", "*.jpeg")
        );
        File f = fc.showOpenDialog(btnUpload.getScene().getWindow());
        if (f != null){
            System.out.println(f);
            atualizaCapaAtual(f);
        }
    }

    @FXML
    private void onBtnConfirmarAction(ActionEvent event) {
        /*
            EDITAR DAO
        */
        Album albumAtualizado = getAlbumAtualizado();
        if (albumAtualizado != null){
            // mandar para o BD
        }
        
    }

    @FXML
    private void onBtnCancelarAction(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    
}
