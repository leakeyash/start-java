package exception;

/**
 * @author henry
 */
public class Account {
    protected double balance;

    public Account(double init){
        this.balance = init;
    }
    public double getBalance(){
        return this.balance;
    }
    public void deposit(double amt){
        this.balance = this.balance + amt;
    }

    public void withdraw(double amt) throws OverdraftException {
        if(amt>this.balance){
            throw new OverdraftException("Overdraft",amt-this.balance);
        }
        else {
            this.balance = this.balance - amt;
        }
    }
}
