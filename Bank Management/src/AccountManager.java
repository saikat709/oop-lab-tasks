import accounts.Account;
import accounts.CurrentAccount;
import accounts.DepositPremiumAccount;
import accounts.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
    Scanner input;
    List<Account> accounts;

    public void run(){
        input = new Scanner(System.in);
        accounts = new ArrayList<>();

        Account a = new SavingAccount("id1", "saikat", 10);
        Account b = new CurrentAccount("id2", "saikat" );
        Account c = new DepositPremiumAccount("id3", "Person", 25);

        accounts.add(a);
        accounts.add(b);
        accounts.add(c);

        while (true){
            System.out.println("Choose a option: ");
            System.out.println("1. Create Account ");
            System.out.println("2. Debit ");
            System.out.println("3. Credit ");
            System.out.println("4. Transfer ");
            System.out.println("5. Exit");
            System.out.print( "\nYour choice: ");

            int choice = input.nextInt();
            input.nextLine();

            if ( choice == 1 ){
                Account acc = createAccount();
                accounts.add(acc);
                System.out.println(acc.toString() + "  created successfully.\n");
            }
            else if ( choice == 2 ){
                System.out.print("Enter account id: ");
                String id = input.nextLine();
                System.out.print("Enter amount:     ");
                int amount = input.nextInt();
                Account acc = getAccountById(accounts, id);
                if ( acc == null ){
                    System.out.println("Account with id " + id + " not found.\n");
                } else {
                    acc.debit(amount);
                }
            }
            else if ( choice == 3 ){
                System.out.print("Enter account id: ");
                String id = input.nextLine();
                System.out.print("Enter amount:     ");
                int amount = input.nextInt();
                Account acc = getAccountById(accounts, id);
                if ( acc == null ){
                    System.out.println("Account with id " + id + " not found.\n");
                } else {
                    acc.credit(amount);
                }
            }

            else if ( choice == 4 ) {
                System.out.print("Enter your account id: ");
                String id = input.nextLine();
                System.out.print("Enter other account id: ");
                String otherId = input.nextLine();
                System.out.print("Enter amount: ");
                int amount = input.nextInt();

                Account acc1 = getAccountById(accounts, id);
                Account acc2 = getAccountById(accounts, otherId);

                if ( acc1 == null ){
                    System.out.println("Account with id " + id + " not found.\n");
                } else if ( acc2 == null ){
                    System.out.println("Account with id " + otherId + " not found.\n");
                } else {
                    acc1.transferTo(acc2, amount);
                }
            }
            else if ( choice == 5 ){
                System.out.println("Thank you for using this program.\n");
                break;
            }
            else {
                System.out.println("Wrong choice.");
            }
        }
    }


    public Account createAccount(){
        System.out.println("Types of account: ");
        System.out.println("1. Saving Account ");
        System.out.println("2. Current Account ");
        System.out.println("3. Deposit Account ");

        System.out.print("Enter type of your account: ");

        int type = input.nextInt();
        input.nextLine();

        while( type > 3 || type < 1 ){
            System.out.print("Enter valid account type: ");
            type = input.nextInt();
            input.nextLine();
        }

        System.out.print("Id: ");
        String id = input.nextLine();
        System.out.print("Name: ");
        String name = input.nextLine();

        switch (type){
            case 1: return new SavingAccount(id, name);
            case 2: return new CurrentAccount(id, name);
            case 3: return new DepositPremiumAccount(id, name);
            default: return null;
        }
    }

    public Account getAccountById(List<Account> acs, String id){
        for( Account ac : acs ){
            if (ac.getId().equals(id)){
                return ac;
            }
        }
        return null;
    }
}
