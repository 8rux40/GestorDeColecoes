package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.imageio.ImageIO;
import model.dao.AlbumDao;
import model.dao.DaoFactory;
import model.dao.MidiasDisponiveisDao;
import model.dao.TipoDeMidiaDao;
import model.entity.Album;
import model.entity.TipoDeMidia;

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
    
    private Image capa;
    @FXML
    private ToggleButton btnStatus;
    
    private File fCapa;
    @FXML
    private ImageView ivCapa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void inserirAlbum(Album a){
        MidiasDisponiveisDao dao = DaoFactory.createMidiasDisponiveisDao();
        TipoDeMidiaDao tdmDao = DaoFactory.createTipoDeMidiaDao();
        AlbumDao aDao = DaoFactory.createAlbumDao();
        List<TipoDeMidia> midias = new ArrayList<>();
        if (cbCd.isSelected()) midias.add(tdmDao.findById(TipoDeMidia.CD));
        if (cbDvd.isSelected()) midias.add(tdmDao.findById(TipoDeMidia.DVD));
        if (cbBluray.isSelected()) midias.add(tdmDao.findById(TipoDeMidia.BluRay));
        if (cbVinil.isSelected()) midias.add(tdmDao.findById(TipoDeMidia.Vinil));
        if (cbK7.isSelected()) midias.add(tdmDao.findById(TipoDeMidia.K7));
        aDao.insert(a);
    }
    
    protected static File salvarImagem(File imgFile) {
        try {
            BufferedImage bImage = ImageIO.read(imgFile);
            System.out.println("Pegando imagem: "+imgFile.getAbsolutePath());
            Path currentRelativePath = Paths.get("");
            String str = String.format(
                "%s%s%s", 
                currentRelativePath.toAbsolutePath().toString(),
                "/src/view/img/capa/",
                imgFile.getName().replaceAll(" ", "-")
            );
            ImageIO.write(bImage, "jpg", new File(str));
            return new File(str);
        } catch (IOException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
        System.out.println("Images were written succesfully.");
        return null;
    }
    
    @FXML
    private void onBtnUploadAction(ActionEvent event) {
        /*sagu
            CAIXA DE DIALOGO PARA INSERIR A IMAGEM DE CAPA
        */
        FileChooser fc = new FileChooser();
        fc.setTitle("Escolha uma imagem para ser capa do Álbum");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("JPG", "*.jpg"),
            new FileChooser.ExtensionFilter("PNG", "*.png"),
            new FileChooser.ExtensionFilter("JPEG", "*.jpeg")
        );
        File f = fc.showOpenDialog(btnUpload.getScene().getWindow());
        f = salvarImagem(f);
        if (f != null){
            try {
                fCapa = f;
                capa = new Image(new FileInputStream(fCapa));
                ivCapa.setImage(capa);
                System.out.println(capa);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NovoAlbumController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void onBtnConfirmarAction(ActionEvent event) {
        Album a = new Album();
        try {
            a.setAnoLancamento(Integer.parseInt(txtAno.getText()));
            a.setArtista(txtArtista.getText());
            a.setTitulo(txtTitulo.getText());
            a.setCapa(fCapa);
            a.setStatus(btnStatus.isSelected()?1:0);
            
        } catch (NumberFormatException e){
            Util.mostraAlerta("Erro", "Erro ao tentar inserir novo álbum.", "Ano de lançamento inválido!", Alert.AlertType.ERROR);
        }
        inserirAlbum(a);
        fechaJanela();
    }

    @FXML
    private void onBtnCancelarAction(ActionEvent event) {
        fechaJanela();
    }

    @FXML
    private void onBtnStatusAction(ActionEvent event) {
    }
    
    private void fechaJanela(){
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.fireEvent(new WindowEvent(btnCancelar.getScene().getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST));
        //stage.close();
    }
    
}
