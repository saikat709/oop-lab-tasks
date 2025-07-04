package accounts;

public abstract class Account {
    private String id;
    private String name;
    private int balance;

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public abstract int getInterest(int amount);

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        balance += amount + getInterest(amount);
        return balance;
    }

    public int debit(int amount) {
        if (amount <= balance){
            balance -= amount;
        } else {
            System.out.println("Amount exceeded balance.");
        }
        return balance;
    }

    public int transferTo(Account account, int amount) {
        if ( amount <= balance ){
            account.credit(amount);
            balance -= amount;
            System.out.println("Transferred from " + this.toString() + " to " + account.toString() + "\n");
        } else {
            System.out.println("Amount exceeded balance.\n");
        }
        return balance;
    }

    @Override
    public String toString() {
        return "Account[id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
}