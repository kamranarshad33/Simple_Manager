


import java.io.*;
import java.util.*;

public class Account{
    private double balance;
    private String accttype;
    private String bankname;
    private String routing;
    private LinkedList<Transaction> transactions;
    

    public Account(){

    }


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


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccttype() {
        return accttype;
    }

    public void setAccttype(String accttype) {
        this.accttype = accttype;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getRouting() {
        return routing;
    }

    public void setRouting(String routing) {
        this.routing = routing;
    }

    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    



    public String toString() {
        return "Account{balance=" + balance + ", accttype=" + accttype + ", bankname=" + bankname + ", routing=" + routing + '}';
    }

}