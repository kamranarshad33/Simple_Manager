

import java.io.BufferedReader;
import java.util.*;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ManagementApp{
    public static void main(String[] args) throws IOException{

        Account[] bankAccs = new Account[10];
        int maxacct = 10;
        int acctcounter = 0;
        Transaction[] transations = null;

/*
        //read from files to create objects: loadData();
            LinkedList<Bank> users = new LinkedList<Bank>();
            try {
               loadData(users);
               System.out.println(users.size());
            }
            catch (FileNotFoundException f) {
        
            }
            catch (IOException i) {
            
            }
            //addUser(info);
            //validateUser(user)
            //addBankAccount(info);
            //validateAcc(acc)
        //do you have an account?

 */
      JOptionPane.showMessageDialog(null,"Welcome to the Money Manager!");
      
      //yes? || no?
      //gather acc info || make account?
      //validate acc info || yes? / no?
      //valid? / not valid? || gather new acc info / quit
      //main menu || again? / signup? / quit? || new? / not new?
      //options || back to 3.1 / back to 3.2 / quit || back to 3.1 / again? / quit?
      //options || looped sections or quit || looped section / back to 5.3 / quit
        
      //login/signup method calls here
      
      // Different methods based on existing or new account path?

        String menu = getMenu();
        
        int menuOption = 0;
        do{
            menuOption = getMenuOption(menu, menu.length());
            switch(menuOption){
                case 1:
                    JOptionPane.showMessageDialog(null,"Add Bank Account");
                    addBankAcc(bankAccs[acctcounter]);
                    acctcounter++;
                    
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "add transactions");
                    String filep = JOptionPane.showInputDialog("Enter the file path to read the transactions from a file");
                 
                    getTransactions(filep);
                    JOptionPane.showMessageDialog(null, "Transactions Added Sucessfully!!");

                    //getBankAcc(UserObj); //choose which bank account to make the transaction with
                    //newTransaction(bankAcc); //make transaction (withdrawal, disposit)
                    //receipt(); //can be done at end of transaction instead
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Search All transaction");

                   // historySearch();
                    //historySearch(UserObj);
                    //historyReport() //reporting done at end of search instead
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "user report");
                    //generateReport(UserObj);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "quit");
                    //Quits the program //System.exit()??
                    //no action required here
                    break;
                default:
                    //never reached
                    JOptionPane.showMessageDialog(null, "How did you get here???");
                    break; 
            }
        }while(menuOption != 5);
    }
    

    public static String getMenu(){
        String[] menu = {"Add Bank Account", "Add Transaction", "Search Transaction History", "Generate Report", "Quit"};
        String menuStr = "";
        for(int i = 0; i < menu.length; i++){
            menuStr += (i+1)  + ") " + menu[i] + "\n";
        }
        return menuStr;      
    }

    public static String getAcctMenu(){
        String accttype = "What type of Account you want to add? \n 1: Saving Acct\n 2: Checking Acct\n 3: Credit Card";
        return accttype;
    }


    public static int getMenuOption(String menu, int length){
        int option = 0;
        do{
            try{
                option = Integer.parseInt(JOptionPane.showInputDialog("Choose a menu option number: \n" + menu));
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error: Menu Option needs to be a number between 1 & " + length);
            }
        }while(option < 1 || option > length);
        return option;
    }

    /*
    
    public static void loadData(LinkedList<Bank> users) throws FileNotFoundException, IOException {
      // prepopulate date from input file
      Bank user;
      String filepath = "./prepop.txt";
      
      File file = new File(filepath);
      Scanner scan = new Scanner(file);
      String line = "";
      
      while (scan.hasNextLine()) {
         line = scan.nextLine();
         Scanner scanLine = new Scanner(line);
         scanLine.useDelimiter(",");
         String uname = scanLine.next().trim();
         //System.out.println(uname);
         String pw = scanLine.next().trim();
         //System.out.println(pw);
         String acctType = scanLine.next().trim();
         //System.out.println(acctType);
         double bal = Double.parseDouble(scanLine.next().trim());
         //System.out.println(bal);
         
         // Pre populate user
         
         user = new Bank("Money Manager", bal);
         user.users.put(uname, pw);
        // user.addCheckingAcc(uname, pw, bal);
         users.add(user);


         //users.addLast(new Bank("Money Manager", bal));
         //users.getFirst().users.put(uname, pw);

         //System.out.println(user.users.entrySet());
      }
    }
    */

    
    public static void addBankAcc(Account bankaccs) {
      String accounttype="";
      String acctrouting="";
      double balance = 0;


      String acctname = JOptionPane.showInputDialog(null, "Enter Bank Name");

      accounttype = JOptionPane.showInputDialog(null, "Choose account type:\n 1) Checking\n 2) Savings\n 3) Credit");

      acctrouting = JOptionPane.showInputDialog(null, "Enter the routing/acct number for account");

      balance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter initial balance: "));
      
      


      bankaccs = new Account(accounttype,acctname,acctrouting , balance);


               JOptionPane.showMessageDialog(null, "Account created successfully!");
    }
    


	public static Transaction[] getTransactions(String path) throws FileNotFoundException, IOException{ //Begin getTransactions
		
        // for testing purposes we already prepopulated a file
        String testpath = "prepop.txt";
        BufferedReader br = new BufferedReader(new FileReader(new File(testpath)));
		String line;
		Scanner scan = null;
		int count = 0;
		while( (line = br.readLine()) != null) {
			count++;
		}
		
		br = new BufferedReader(new FileReader(new File(testpath)));
		Transaction t;
                
        String transType;
        String transCategory;
        double amount;
        String TransDate;

		Transaction[] transaction = new Transaction[count];
		int i = 0;
		while((line = br.readLine()) != null) {
			scan = new Scanner(line);
			scan.useDelimiter(",");
			transType = scan.next().trim();
			transCategory = scan.next().trim();
			TransDate = scan.next().trim();
            amount = Double.parseDouble(scan.next().trim());
			t = new Transaction(transType,transCategory,amount,TransDate);
			transaction[i++] = t;
		}
		return transaction;
	
   
   } // End method


    public static Transaction[] sortByAmount(Transaction[] transactions) {
        double min=0;
        int		k=0;
        for(int i=0; i<transactions.length-1; i++){
            min = transactions[i].getAmount();
            for(int j=i+1; j<transactions.length; j++){
                if(min > transactions[j].getAmount()) {
                    min = transactions[j].getAmount();
                    k=j; }}
            if(transactions[i].getAmount() > min){ //swap
                Transaction temp = transactions[i];
                transactions[i] = transactions[k];
                transactions[k] = temp;
            } }
        return transactions;
    }






    // public static void receipt() {

   // }
 /*
    public static void historySearch() {
        int option = 0;
        String date = "";
        int category = 0;
 
        do{
            try {
               option = Integer.parseInt(JOptionPane.showInputDialog(null, "Search transactions by:\n 1) Date\n 2) Category",
                  "Search Transaction History", JOptionPane.QUESTION_MESSAGE));
               if (option < 1 || option > 2) {
                  throw new NumberFormatException();
               }
               else {
                  switch(option) {
                     case 1: // Search by Date
                        do {
                           date = JOptionPane.showInputDialog(null, "Enter a date in the format of MM/DD/YY: ");
                        
                        } while (!validDate(date)); 
                        break;
                     case 2: // Search by transaction category
                        do  {
                           category = Integer.parseInt(JOptionPane.showInputDialog(null, "Search by:\n 1) Deposits\n 2) Withdrawals"));
                           if (category < 1 || category > 2) {
                              throw new NumberFormatException();
                           }
                        } while (category < 1 || category > 2);
                        break;
                  }
               }
            }
            catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "Error: Search Choice must be number 1 or 2.  Please try again.");
            }
        }while(option < 1 || option > 2);      
    }
    
    public static boolean validDate(String date) { // return boolean
         boolean valid = false;  // true only for testing
         
            if (date.charAt(2) == '/' && date.charAt(5) == '/') { // Check for correct format of slashes
               valid = true;
            }
            else {
               JOptionPane.showMessageDialog(null, "Error: Date must be in format MM/DD/YY. Please try again.");
            }
         return valid;
    }


    
    public static void historyReport() {
    
    }
    
    public static void generateReport() {
      // toString()s
    }

  */


}