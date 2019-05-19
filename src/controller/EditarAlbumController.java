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
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.dao.DaoFactory;
import model.dao.MidiasDisponiveisDao;
import model.dao.TipoDeMidiaDao;
import model.entity.Album;
import model.entity.MidiasDisponiveis;
import model.entity.TipoDeMidia;
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
    
    private File fCapa;

    private Album albumSelecionado;
    @FXML
    private ToggleButton btnStatus;
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
        try {
            albumSelecionado = a;
            txtArtista.setText(a.getArtista());
            txtTitulo.setText(a.getTitulo());
            txtAno.setText(String.format("%d", a.getAnoLancamento()));
            for (TipoDeMidia tdm : DaoFactory.createMidiasDisponiveisDao().findTipoDeMidiaByAlbum(a)){
                switch(tdm.getId()){
                    case TipoDeMidia.CD:{
                        cbCd.setSelected(true);
                    } break;
                    case TipoDeMidia.DVD:{
                        cbDvd.setSelected(true);
                    } break;
                    case TipoDeMidia.BluRay:{
                        cbBluray.setSelected(true);
                    } break;
                    case TipoDeMidia.Vinil:{
                        cbVinil.setSelected(true);
                    } break;
                    case TipoDeMidia.K7:{
                        cbK7.setSelected(true);
                    } break;
                }
            }
            fCapa = a.getCapa();
            capa.setImage(new Image(new FileInputStream(fCapa)));
            btnStatus.selectedProperty().set(a.getStatus() == 1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EditarAlbumController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            fCapa = f;
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
            a.setTitulo(txtTitulo.getText());
            a.setId(albumSelecionado.getId());
            a.setStrCapa(albumSelecionado.getStrCapa()); // VER DEPOIS
            a.setStatus(btnStatus.isSelected() ? 1 : 0);
            a.setCapa(fCapa);
            
            MidiasDisponiveisDao dao = DaoFactory.createMidiasDisponiveisDao();
            TipoDeMidiaDao tdmDao = DaoFactory.createTipoDeMidiaDao();
            List<TipoDeMidia> midias = new ArrayList<>();
            if (cbCd.isSelected()) midias.add(tdmDao.findById(TipoDeMidia.CD));
            if (cbDvd.isSelected()) midias.add(tdmDao.findById(TipoDeMidia.DVD));
            if (cbBluray.isSelected()) midias.add(tdmDao.findById(TipoDeMidia.BluRay));
            if (cbVinil.isSelected()) midias.add(tdmDao.findById(TipoDeMidia.Vinil));
            if (cbK7.isSelected()) midias.add(tdmDao.findById(TipoDeMidia.K7));
            
            dao.deleteAllByAlbum(albumSelecionado);
            for (TipoDeMidia midia : midias){
                dao.insert(new MidiasDisponiveis(a, midia));
            }
            
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
            DaoFactory.createAlbumDao().update(albumAtualizado);
        }
        fechaJanela();
    }

    @FXML
    private void onBtnCancelarAction(ActionEvent event) {
        fechaJanela();
    }
    
    private void fechaJanela(){
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.fireEvent(new WindowEvent(btnCancelar.getScene().getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST));
        //stage.close();
    }

    @FXML
    private void onBtnStatusAction(ActionEvent event) {
        albumSelecionado.setStatus(btnStatus.isSelected() ? 1 : 0);
    }
    
}
