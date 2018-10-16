package exception;

public class CheckingAccount extends Account{

    private double overdraftProtection;
    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, double protect){
        this(balance);
        this.overdraftProtection = protect;
    }

    @Override
    public void withdraw(double amt) throws OverdraftException {
        if(amt>this.balance + this.overdraftProtection){
            throw new OverdraftException("Overdraft with protection",amt-this.balance-this.overdraftProtection);
        }
        this.balance = this.balance - amt;
    }
}
