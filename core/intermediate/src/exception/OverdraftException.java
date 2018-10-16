package exception;

/**
 * @author henry
 */
public class OverdraftException extends Exception{
    private double deficit;

    public OverdraftException(String message, Double deficit){
        super(message);
        this.deficit = deficit;
    }

    public double getDeficit(){
        return this.deficit;
    }
}
