package accounts;

public class DepositPremiumAccount extends Account {
    private int depositCount;

    public DepositPremiumAccount(String id, String name) {
        this(id, name, 0);
    }

    public DepositPremiumAccount(String id, String name, int balance) {
        super(id, name, balance);
        depositCount = 0;
    }

    @Override
    public int credit(int amount) {
        depositCount++;
        return super.credit(amount);
    }

    @Override
    public int debit(int amount) {
        if  (depositCount >= 5 ) {
            return super.debit(amount);
        } else {
            System.out.println("Could not withdraw. Need " + String.valueOf(5 - depositCount) + " more installment.\n");
        }
        return this.getBalance();
    }

    @Override
    public int getInterest(int amount) {
        return (int) (amount * 0.07);
    }

    @Override
    public int transferTo(Account account, int amount) {
        System.out.println("Can not transfer money from a DepositPremiumAccount.\n");
        return this.getBalance();
    }
}
