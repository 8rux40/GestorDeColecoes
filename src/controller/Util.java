package controller;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 8rux40 
 * @github https://github.com/8rux40
 */
public class Util {
    public static void chamarTela(URL telaUrl) {
        try {
            FXMLLoader loader = new FXMLLoader(telaUrl);
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();
        } catch (Exception e) {
            System.out.println("Erro ao chamar tela! \n" + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void fechaJanela(Stage stage){
        stage.close();
    }
    public static void mostraAlerta(String title, String header, String content, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        
        alert.show();
    }
}
