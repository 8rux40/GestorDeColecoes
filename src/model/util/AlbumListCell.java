package model.util;

import controller.TestefxController;
import controller.Util;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.entity.Album;

/**
 *
 * @author 8rux40
 */
public class AlbumListCell extends ListCell<Album> {

    private HBox content;
    private Label titulo;
    private Label artista;
    private Label anoLancamento;
    private Image capa;
    private ImageView imgCapa;
    
    private Button btnDelete;
    private Button btnEdit;
    
    private HBox midias;
    
    private static Album albumSelecionado;

    public AlbumListCell() {
        super();
        titulo = new Label();
        artista = new Label();
        anoLancamento = new Label();
        imgCapa = new ImageView();
        btnDelete = new Button();
        btnEdit = new Button();
        
        midias = new HBox();
                
        VBox descricao = new VBox(
            titulo, 
            new HBox(new Label("por "),artista),
            anoLancamento,
            midias
        );
        
        VBox botoes = new VBox(
            btnDelete,
            btnEdit
        );
        
        content = new HBox(
            imgCapa,
            descricao,
            botoes 
        );
        
        descricao.setStyle("-fx-padding: 0px 0px 0px 20px;");
        descricao.setPrefWidth(605);
        botoes.setPrefWidth(25);
        btnDelete.setPrefSize(25, 25);
        btnEdit.setPrefSize(25, 25);
        anoLancamento.setStyle("-fx-padding: 5px 0px 0px 0px;");
        btnDelete.getStyleClass().add("btn");
        btnDelete.getStyleClass().add("btn-delete");
        btnEdit.getStyleClass().add("btn");
        btnEdit.getStyleClass().add("btn-edit");
        
        midias.setStyle("-fx-padding: 8px 0px 0px 0px;");
        
    }

    @Override
    protected void updateItem(Album item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null && !empty) {
            if (item.getCapa() != null) {
                atualizaCapa(item.getCapa());
                //imgCapa.setImage(item.getCapa());
            } else {
                atualizaCapa(new Image("/view/img/album-256.png"));
                //imgCapa.setImage(new Image("/view/img/album-256.png"));
            }
            atualizaTitulo(item.getTitulo());
            atualizaArtista(item.getArtista());
            atualizaAnoLancamento(item.getAnoLancamento());
            atualizaMidias(item.getMidiasDisponiveis());
            setGraphic(content);

            setAlignment(Pos.CENTER_LEFT);
            setContentDisplay(ContentDisplay.TOP);
            setPrefWidth(200);
            
            btnDelete.setOnAction((t) -> {
                TestefxController.removerAlbum(item);
            });
            
            btnEdit.setOnAction((t) -> {
                editarAlbum(item);
            });

        } else {
            setGraphic(null);
        }
    }
    
    private void setAlbumSelecionado(Album a){
        albumSelecionado = a;
    }
    
    public static Album getAlbumSelecionado(){
        return albumSelecionado;
    }
    
    private void editarAlbum(Album a){
        /*
            Abre tela de edição
        */
        setAlbumSelecionado(a);
        Util.chamarTela(getClass().getResource("/view/EditarAlbum.fxml"));
    }

    private void atualizaCapa(Image image) {
        imgCapa.setImage(image);
        imgCapa.setFitWidth(150);
        imgCapa.setFitHeight(150);
        imgCapa.getStyleClass().add("album-capa");
    }
    
    private void atualizaTitulo(String titulo){
        this.titulo.setText(titulo);
        this.titulo.setPrefHeight(85);
        this.titulo.getStyleClass().add("album-titulo");
    }
    
    private void atualizaArtista(String art){
        artista.setText(art);
        artista.getStyleClass().add("album-artista");
    }
    
    private void atualizaAnoLancamento(int ano){
        anoLancamento.setText(String.format("%d", ano));
        anoLancamento.getStyleClass().add("album-ano");
    }
    
    private void atualizaMidias(List<Integer> midias){
        String[] midia = {"CD","DVD", "Vinil", "BluRay", "K7"};
        
        for(Integer m : midias){
            Label lblMidia = new Label(midia[m-1]);
            lblMidia.getStyleClass().add("etiqueta");
            this.midias.getChildren().add(lblMidia);
            this.midias.getChildren().add(new Label(" "));
        }
    }
}
