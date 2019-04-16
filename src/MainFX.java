/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author btardin
 */
public class MainFX extends Application {
    private static Scene scene;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/view/testefx.fxml"));
            scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true);
//            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static Scene getScene(){
        return MainFX.scene;
    }
    
}
