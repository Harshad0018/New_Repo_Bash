package GIT_;
import java.util.Scanner; 
class Bank_Details {  
	private String name;
    private String acc_no;    
    private long balance;
    private String acc_type;  
   
    Scanner sc = new Scanner(System.in);  
    //method to open new account  
    public void create_Account() {  
        System.out.print("Enter Account Noumber: ");  
        acc_no = sc.next();  
        System.out.print("Mention Account Type: ");  
        acc_type = sc.next();  
        System.out.print("Enter Deposited Initial Balance: ");  
        balance = sc.nextLong(); 
        System.out.print("Enter Account Holder Name: ");  
        name = sc.next();  
        
    }  
    
    public void showAccount_Details() {  
        System.out.println("Name of account holder: " + name);  
        System.out.println("Account no.: " + acc_no);  
        System.out.println("Account type: " + acc_type);  
        System.out.println("Balance: " + balance);  
    }  
    //method to deposit money  
    public void deposit() {  
        long amount;  
        System.out.println("Enter the amount you want to deposit: ");  
        amount = sc.nextLong();  
        balance = balance + amount;  
    }  
    //method to withdraw money  
    public void withdrawal() {  
        long amount;  
        System.out.println("Enter the amount you want to withdraw: ");  
        amount = sc.nextLong();  
        if (balance >= amount) {  
            balance = balance - amount;  
            System.out.println("Balance after withdrawal: " + balance);  
        } else {  
            System.out.println("Your balance is less than " + amount + "\tTransaction failed...!!" );  
        }  
    }  
    //method to search an account number  
    public boolean search(String ac_no) {  
        if (acc_no.equals(ac_no)) {  
        	showAccount_Details();  
            return (true);  
        }  
        return (false);  
    }  

}  
public class Banking_GIT_Demo {  
    public static void main(String arg[]) {  
        Scanner sc = new Scanner(System.in);  
        //create initial accounts  
        Banking_GIT_Demo b =new Banking_GIT_Demo();
        System.out.print("Enter How many Account you want to create ");  
        int n = sc.nextInt();  
        Bank_Details C[] = new Bank_Details[n];  
        for (int i = 0; i < C.length; i++) {  
            C[i] = new Bank_Details();  
            C[i].create_Account();  
        }  
        // loop runs until number 5 is not pressed to exit  
        int ch;  
        do {  
            System.out.println("\n **Banking System Application**");  
            System.out.println("1.Show account details \n 2. Search by Account number\n 3. Deposit to the amount \n 4. Withdraw from the amount \n 5.Exit ");  
            System.out.println("Enter your choice: ");  
            ch = sc.nextInt();  
                switch (ch) {  
                    case 1:  
                        for (int i = 0; i < C.length; i++) {  
                            C[i].showAccount_Details();  
                        }  
                        break;  
                    case 2:  
                        System.out.print("Enter account noumber you want to search: ");  
                        String ac_no = sc.next();  
                        boolean found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("This account doesn't exist..!!");  
                        }  
                        break;  
                    case 3:  
                        System.out.print("Enter Account no. : ");  
                        ac_no = sc.next();  
                        found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                C[i].deposit();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("This Account doesn't exist..!!");  
                        }  
                        break;  
                    case 4:  
                        System.out.print("Enter Account No : ");  
                        ac_no = sc.next();  
                        found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                C[i].withdrawal();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        break; 
//                 
                    case 5:  
                        System.out.println("Thank You...Have a Good Day!....");  
                        break;  
                }  
            }  
            while (ch != 6);  
        }  
    }  
