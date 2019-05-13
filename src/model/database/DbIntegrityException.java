package model.database;

/**
 *
 * @author 8rux40
 * @github https://github.com/8rux40
 */
public class DbIntegrityException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    public DbIntegrityException(String msg){
        super(msg);
    }
}