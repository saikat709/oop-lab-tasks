import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account a = new Account("id1", "saikat", 10);
        Account b = new  Account("id2", "saikat" );
        Account c = new Account("id3", "Person", 25);

        List<Account> accounts = new ArrayList<>();
        accounts.add(a);
        accounts.add(b);
        accounts.add(c);
        Scanner input = new Scanner(System.in);

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
                System.out.print("Id: ");
                String id = input.nextLine();
                System.out.print("Name: ");
                String name = input.nextLine();
                Account acc = new Account(id, name);
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
                    System.out.println("Transferred from " + acc1.toString() + " to " + acc2.toString() + "\n");
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

    public static Account getAccountById(List<Account> acs, String id){
        for( Account ac : acs ){
            if (ac.getId().equals(id)){
                return ac;
            }
        }
        return null;
    }
}
