package controller;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author btardin
 */
public class Util {
    public static void chamarTela(URL telaUrl) {
        try {
            FXMLLoader loader = new FXMLLoader(telaUrl);
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Erro ao chamar tela! \n" + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void fechaJanela(Stage stage){
        stage.close();
    }
}
