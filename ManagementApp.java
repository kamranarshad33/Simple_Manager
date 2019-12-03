

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
        Transaction[] transactions = null;

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
                 
                    transactions = getTransactions(filep);
                    JOptionPane.showMessageDialog(null, "Transactions Added Sucessfully!!");

                    //getBankAcc(UserObj); //choose which bank account to make the transaction with
                    //newTransaction(bankAcc); //make transaction (withdrawal, disposit)
                    //receipt(); //can be done at end of transaction instead
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Search All transaction");

                    historySearch(transactions);
                    //historySearch(UserObj);
                    //historyReport() //reporting done at end of search instead
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "User Report");
                    generateReport(transactions);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Quitting program...");
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
      int accounttype = 0;
      String acctrouting="";
      double balance = 0;
      String acctname="";

      do {
          acctname = JOptionPane.showInputDialog(null, "Enter Bank Name");
      }
      while (acctname == null || acctname.equals(""));

      do {


              try {
                  accounttype = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose account type:\n 1) Checking\n 2) Savings\n 3) Credit"));
              } catch (NumberFormatException e) {
                  JOptionPane.showMessageDialog(null, "Error: Choice must be number 1, 2, or 3.  Please try again.");
              }
      }
      while(accounttype < 1 || accounttype > 4);

      do {
          acctrouting = JOptionPane.showInputDialog(null, "Enter the routing/acct number for account");
      }
      while (acctrouting == null || acctrouting.equals(""));
          balance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter initial balance: "));


          if (accounttype == 1) {
              bankaccs = new CheckinAcc("Checking Account", acctname, acctrouting, balance);
              JOptionPane.showMessageDialog(null, "Checking Account Added successfully!");
          } else if (accounttype == 2) {
              bankaccs = new SavingAcc("Saving Account", acctname, acctrouting, balance);
              JOptionPane.showMessageDialog(null, "Saving Account Added successfully!");
          } else if (accounttype == 3) {
              bankaccs = new CreditAcct("Credit Account", acctname, acctrouting, balance);
              JOptionPane.showMessageDialog(null, "Checking Account Added successfully!");
          }
          else {
              bankaccs = new CheckinAcc("Checking Account", acctname, acctrouting, balance);
          }

          
             
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
    
   public static void historySearch(Transaction[] transactions) {
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
                        historyReport(date, transactions);
                        break;
                     case 2: // Search by transaction category
                        do  {
                           category = Integer.parseInt(JOptionPane.showInputDialog(null, "Search by:\n 1) Deposits\n 2) Withdrawals"));
                           if (category < 1 || category > 2) {
                              throw new NumberFormatException();
                           }
                        } while (category < 1 || category > 2);
                        historyReport(category, transactions);
                        break;
                  }
               }
            }
            catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "Error: Search Choice must be number 1 or 2.  Please try again.");
            }
        }while(option < 1 || option > 2);    
    }
    
    public static boolean validDate(String date) {
         if(date.length() != 8){
            JOptionPane.showMessageDialog(null, "Error: Date must be in format MM/DD/YY. Please try again.");
            return false;
         }
         else{
            for(int i = 0; i < date.length(); i++){
                if(i == 0){
                    if(date.charAt(i) != '0' || date.charAt(i) != '1'){
                        JOptionPane.showMessageDialog(null, "Error: The first number in the date must be 0 or 1. Please try again.");
                        return false;
                    }
                }
                else if(i != 2 || i != 5){
                    if(!Character.isDigit(date.charAt(i))){
                        JOptionPane.showMessageDialog(null, "Error: The date can only contain numbers and /. Please try again.");
                        return false;
                    }
                }
                else{
                    if(date.charAt(i) != '/'){
                        JOptionPane.showMessageDialog(null, "Error: The third and fifth character in the date must be a /. Please try again.");
                        return false;
                    }
                }
            }
            return true;
        }
    }
    
    public static void historyReport(String date, Transaction[] transactions) {
        String report = searchTransactions(date, transactions);
        writeReport(report);
    }
    
    public static void historyReport(int category, Transaction[] transactions) {
        String report = "";
        if(category == 1){
            //unless we are going to use W for withdrawal
            String type = "Withdrawal";
            report = searchTransactions(type, transactions);
        }
        else if(category == 2){
            //unless we are going to use D for deposit
            String type = "Deposit"; 
            report = searchTransactions(type, transactions);
        }
        writeReport(report);
    }
    
    public static String searchTransactions(String key, Transaction[] transactions){
        //LinkedList<Transaction> transactions = getTransactions();
        String report = "";
        if(!Character.isDigit(key.charAt(0))){
            for(Transaction curr : transactions){
                if(curr.getTransType().equals(key)){
                    report += curr.toString();
                }
            }
        }
        else{
            for(Transaction curr : transactions){
                if(curr.getDate().equals(key)){
                    report += curr.toString();
                }
            }
        }
        return report;
    }
    
    public static void writeReport(String report){
        JOptionPane.showMessageDialog(null, report);
    }
    
    /**
      Generates and displays formatted report of account transactions.
      @param transactions transactions list
    */
    public static void generateReport(Transaction[] transactions) {
      // String transaction/account information will be appended to
      String report = "Transactions Report:\n\nDate | Category | Amount\n";
      
      // Append transaction/account information on to report, then
      // display formatted report to user
      try {
         sortByAmount(transactions);
         for (int i = 0; i < transactions.length; i++) {
            // appends new line of transaction/account informaton
            report += transactions[i].toString() + "\n";
         }
         // displays report
         JOptionPane.showMessageDialog(null, report);  
      }
      // Return error message with null pointer errors
      catch(NullPointerException n) {
         JOptionPane.showMessageDialog(null, "Error. Please try again.");
      }
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
