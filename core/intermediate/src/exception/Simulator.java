package exception;

/**
 * @author henry
 */
public class Simulator {
    public static void main(String[] args){
        Account ac = new Account(65);
        try{
            ac.withdraw(66);
        }
        catch (OverdraftException ex){
            System.out.println(ex.getMessage()+","+ex.getDeficit());
        }
        CheckingAccount ca = new CheckingAccount(66,22);
        try{
            ca.withdraw(100);
        }
        catch (OverdraftException ex){
            System.out.println(ex.getMessage()+","+ex.getDeficit());
        }
    }
}
