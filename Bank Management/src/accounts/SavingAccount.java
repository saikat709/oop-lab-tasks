package accounts;

public class SavingAccount extends Account {
    public SavingAccount(String id, String name) {
        this(id, name, 0);
    }

    public SavingAccount(String id, String name, int balance) {
        super(id, name, balance);
    }

    @Override
    public int debit(int amount) {
        if ( this.getBalance() - amount > 100  ){
            super.debit(amount);
        } else {
            System.out.println("Insufficient balance. Account must have 1000.\n");
        }
        return this.getBalance();
    }

    @Override
    public int getInterest(int amount) {
        return (int) ( 0.025 * amount );
    }
}
