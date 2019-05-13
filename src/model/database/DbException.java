package model.database;

import controller.Util;
import javafx.scene.control.Alert;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public class DbException extends RuntimeException {
    
    private static final long serialVersionUID = 1;
    
    public DbException(String msg){
        super(msg);
        Util.mostraAlerta(
            "Erro na Base de Dados", 
            "Um problema interno ocorreu na base de dados!", 
            msg, 
            Alert.AlertType.ERROR
        );
    }
    
}