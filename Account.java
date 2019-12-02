import java.io.*;
import java.util.*;

/**
   Defines information related to the process of creating and managing an 
   account that includes the balance, type, bank name, routing number, and list
   of transactions. 
*/
public class Account{
    // Account balance
    private double balance;
    // Account type
    private String accttype;
    // Bank name
    private String bankname;
    // Account routing number
    private String routing;
    // Account's transactions
    private LinkedList<Transaction> transactions;
    
    /**
      Default constructor for Account.
    */
    public Account(){

    }

    /**
      Constructor for Account class that instantiates Account object.
      @param transType account type
      @param bankName name of bank
      @param rounting account routing number
      @param balance account balance
    */
    public Account(String accttype, String bankname, String routing, double balance){

        if (accttype == null || accttype.equals("")) {
            throw new IllegalArgumentException("Account type can't be blank");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("The value can not be less than 0");
        }
        if (bankname == null || bankname.equals("")) {
            throw new IllegalArgumentException("bank name can't be blank");
        }

        if (routing == null || routing.equals("")) {
            throw new IllegalArgumentException("routing number can't be blank");
        }


        this.balance = balance;
        this.accttype=accttype;
        this.bankname=bankname;
        this.routing=routing;
    }

    /**
      Returns balance of account.
      @return balance of account
    */
    public double getBalance() {
        return balance;
    }
    
    /**
      Sets balance of account.
      @param balance balance of account
    */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    /**
      Return type of account.
      @return type of account
    */
    public String getAccttype() {
        return accttype;
    }
    
    /**
      Sets the account type.
      @param account type
    */
    public void setAccttype(String accttype) {
        this.accttype = accttype;
    }
    
    /**
      Returns name of bank.
      @return name of bank
    */
    public String getBankname() {
        return bankname;
    }
    
    /**
      Sets the name of the bank.
      @param name of bank
    */
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }
    
    /**
      Returns the routing number of the account.
      @return account routing number
    */
    public String getRouting() {
        return routing;
    }
    
    /**
      Sets the routing number of the account.
      @return account routing number
    */
    public void setRouting(String routing) {
        this.routing = routing;
    }
    
    /**
      Return the list of account transactions.
      @return list of transactions
    */
    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    
    /**
      Returns String of aggregated account information.
      @return overall account information
    */    
    public String toString() {
        return "Account{balance=" + balance + ", accttype=" + accttype + ", bankname=" + bankname + ", routing=" + routing + '}';
    }

}