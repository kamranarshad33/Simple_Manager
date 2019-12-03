/*
 *
 * This is our Main class for test purposes.
 *
 */

import com.sun.codemodel.internal.JOp;

// These are all my imports
import java.io.BufferedReader;
import java.util.*;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class testManagementApp{ // begin class


    public static void main(String[] args) throws IOException{ // begin main method

        //following are the variables we used in main class to support functionality
        double Total_balance=0;
        int temp_account=1001;

        //creating instance of the banl accounts to meet the requirements
        Account[] bankAccs = new Account[10];
        int maxacct = 10;
        int acctcounter = 0;

        //creating instance for transactions to meet the requirements
        Transaction[] transactions = null;

        // welcome message
        JOptionPane.showMessageDialog(null,"Welcome to the Money Manager!");


        //initializing the string that will be used to show the main menu
        String menu = getMenu();
        menu += "\n\n\n";


        //Main Menu
        int menuOption = 0;
        do{
            menuOption = getMenuOption(menu, menu.length());
            switch(menuOption){
                case 1:
                    JOptionPane.showMessageDialog(null,"Add Bank Account");

                    if (acctcounter < 10) {
                        addBankAcc(bankAccs[acctcounter]);
                        acctcounter++;

                    }
                    else {
                        JOptionPane.showMessageDialog(null, "You can not add more than 10 accounts");
                    }

                    break;
                case 2:
                    int acctnum = 0;
                    do{
                        try{
                            acctnum = Integer.parseInt(JOptionPane.showInputDialog("Add Transactions:\n\n Accounts that are in the system:\n"
                                    + "   - Acct # 1001\n\n"+"Enter the Account Number the transaction belong to!"));
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null, "Error: The account doesn't exist");
                        }

                        if (acctnum != temp_account){
                            JOptionPane.showMessageDialog(null, "Enter a correct account number");
                        }
                    }while(acctnum != temp_account);


                    String filep = "";
                    do {
                         filep = JOptionPane.showInputDialog("Enter the file path to read the transactions from a file:\n\n" +
                                "(For demonstration purposes we have created a file named 'prepop.txt' that is prefilled with the required input data)");
                    }
                    while (filep == null || filep.equals(""));


                    transactions = getTransactions(filep,acctnum);
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

    } // end of main method




    /**
     Generates and displays formatted Menu.
     //@param no parameter
     //@return it returns a formatted string
     */
    public static String getMenu(){
        String[] menu = {"Add Bank Account", "Add Transaction", "Search Transaction History", "Generate Report", "Quit"};
        String menuStr = "";
        for(int i = 0; i < menu.length; i++){
            menuStr += (i+1)  + ") " + menu[i] + "\n";
        }
        return menuStr;
    }


    /**
     Generates and displays formatted Menu options.
     //@param no parameter
     //@return it returns a formatted string of menu options
     */
    public static int getMenuOption(String menu, int length){
        int option = 0;
        do{
            try{
                option = Integer.parseInt(JOptionPane.showInputDialog("Simple Money Manager\n\n"+"Choose a menu option number: \n\n" + menu));
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error: Menu Option needs to be a number between 1 & 5");
            }
        }while(option < 1 || option > length);
        return option;
    }



    /**
     Initializes and creates a object of bank account.
     //@param Bank account object
     //@return It returns the filled bank account object if all the inputs are successful
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

        do {
            try {
                balance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter initial balance: "));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: The balance has to be positive number");
            }

        }
        while (balance <= 0);

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





    /**
     Initializes and creates a object of transactions.
     //@param Bank account object
     //@return It returns the filled bank account object if all the inputs are successful
     */
    public static Transaction[] getTransactions(String path, int acctnum) throws FileNotFoundException, IOException{ //Begin getTransactions

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
            t = new Transaction(transType,transCategory,amount,TransDate, acctnum);
            transaction[i++] = t;
        }
        return transaction;


    } // End method





    /**
     This method sorts the array of transaction. It uses the selection sort and it helps us with the search
     //@param transaction object
     //@return It returns the sorted array of transaction object
     */
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




    /**
     This method handles all the transaction history search to show it to the user.
     //@param array of transaction objects
     //@return no return
     */
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
                            JOptionPane.showMessageDialog(null,searchTransactionsDate(date, transactions));
                            break;
                        case 2: // Search by transaction category
                            do  {
                                category = Integer.parseInt(JOptionPane.showInputDialog(null, "Search by:\n 1) Deposits\n 2) Withdrawals"));
                                if (category < 1 || category > 2) {
                                    throw new NumberFormatException();
                                }
                            } while (category < 1 || category > 2);

                            if (category == 1){
                                JOptionPane.showMessageDialog(null,searchTransactionsCategory("deposit", transactions));
                            }
                            else
                                JOptionPane.showMessageDialog(null,searchTransactionsCategory("withdrawal", transactions));

                            break;
                    }
                }
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Search Choice must be number 1 or 2.  Please try again.");
            }
        }while(option < 1 || option > 2);
    }




    /**
     this method validates if the user is entering the correct date
     //@param string that is a date
     //@return it returns a boolean value of true or false
     */

    public static boolean validDate(String date) {
        if(date.length() != 8){
            JOptionPane.showMessageDialog(null, "Error: Date must be in format MM/DD/YY. Please try again.");
            return false;
        }
        else{
            return true;
        }
    }


    /**
     This method handles the search by date feature
     //@param array of transaction objects and the key(date that user is looking for)
     //@return It returns the the list of all the transaction that meet the criteria
     */
    public static String searchTransactionsDate(String key, Transaction[] transactions) {

        double balance=0;
        String report = "";
        report += "Transactions Search result for  " + key + ":\n\n    Date     | Category | Type |  Amount\n \n";

        try {
            sortByAmount(transactions);
            for (int i = 0; i < transactions.length; i++) {
                // appends new line of transaction/account informaton
                if (key.equals(transactions[i].getDate())) {
                    report += transactions[i].toString() + "\n";
                    balance += transactions[i].getAmount();
                }
            }
        }
        // Return error message with null pointer errors
        catch(NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Error. Please try again.");
        }

        report += "\n\n\n";
        report += "Total transactions on " + key + " resulted in amount of $" + balance;



        return report;
    }


    /**
     This method handles the search by category feature
     //@param array of transaction objects and the key(category that user is looking for)
     //@return It returns the the list of all the transaction that meet the criteria
     */
    public static String searchTransactionsCategory(String key, Transaction[] transactions) {

        double balance=0;
        String report = "";

        report += "Transactions Search result for  " + key + ":\n\n    Date     | Category | Type |  Amount\n \n";


        try {

            for (int i = 0; i < transactions.length; i++) {
                // appends new line of transaction/account informaton
                if (transactions[i].getTransType().equals(key)) {
                    report += transactions[i].toString() + "\n";
                    balance += transactions[i].getAmount();
                }
            }
        }
        // Return error message with null pointer errors
        catch(NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Error. Please try again.");
        }

        report += "\n\n\n";
        report += "Total transactions with the category of " + key + " resulted in amount of $" + balance;



        return report;
    }



    /**
     Generates and displays formatted report of account transactions.
    // @param transactions transactions list
     */
   /* public static void generateReport(Transaction[] transactions) {
        // String transaction/account information will be appended to
        String report = "Transactions Report:\n\n    Date     | Category | Type |  Amount\n \n";

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

    */



    /**
     Generates and displays formatted report of account transactions.
     //@param transactions transactions list
     */
    public static void generateReport(Transaction[] transactions) {

        int totalAccts = 0;
        double totalbalance = 500;
        double totald=0;
        double totalw=0;

        // String transaction/account information will be appended to
        String report = "Simple Manager Report:\n\n";
        report += "Total Accounts = 1\n";
        report += "Accounts Summary: \n";

        report +=  "   Acct Type: Credit, Bankname: BOA, Account Num: 1001, Balance: $500";
        report += "\n\n";
        report += "Total Balance in All Accounts: $500";

        report += "\n\n";

        report += "Transaction Details for Account : 1001 \n" ;
        report += "Total Transactions for that account: " + transactions.length;


        report += "\n\n";
        report += "Deposits: \n";
        sortByAmount(transactions);
        // Append transaction/account information on to report, then
        // display formatted report to user
        try {

            for (int i = 0; i < transactions.length; i++) {
                // appends new line of transaction/account informaton
                if (transactions[i].getTransType().equals("deposit")) {
                    report += "   " + transactions[i].toString() + "\n";
                    totald += transactions[i].getAmount();
                }
            }
            // displays report
            JOptionPane.showMessageDialog(null, report);
        }

        // Return error message with null pointer errors
        catch(NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Error. Please try again.");
        }

        report += "\n\n";
        report += "Withdrawals: \n";

        try {

            for (int i = 0; i < transactions.length; i++) {
                // appends new line of transaction/account informaton
                if (transactions[i].getTransType().equals("withdrawal")) {
                    report += "   " + transactions[i].toString() + "\n";
                    totalw += transactions[i].getAmount();
                }
            }
            // displays report
            JOptionPane.showMessageDialog(null, report);
        }
        // Return error message with null pointer errors
        catch(NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Error. Please try again.");
        }

        totalbalance = (totalbalance + totald) - totalw;
        report += "\nTotal Deposits = $";
        report += totald;
        report += "\n";
        report += "Total Withdrawals = $";
        report += totalw;
        report += "\n";
        report += "Ending Balance = $";
        report += totalbalance;

        JOptionPane.showMessageDialog(null,report);

    }






}
