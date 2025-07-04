package accounts;

public class CurrentAccount extends Account {

    public CurrentAccount(String id, String name) {
        this(id, name, 0);
    }

    public CurrentAccount(String id, String name, int balance) {
        super(id, name, balance);
    }

    @Override
    public int getInterest(int amount) {
        return 0;
    }
}
