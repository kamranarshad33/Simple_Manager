import java.util.*;

/**
   Defines information related to the process of creating bank accounts
   that includes creating repository for accounts and tracking the
   total number of accounts.
*/

//linkedlist and/or arraylist
public class Bank extends Account {
    // Repository for bank accounts
    private Account[] bankAccs = new Account[10];
    // Number of bank account limits
    private int maxacct = 10;
    // Tracks number of total bank accounts
    private static int acctcounter = 0;

    /**
      Constructor for Bank class that instantiates Bank object.
    */
    private Bank() {
        //initialize data structures
        // Assigns and places new account within repository
        bankAccs[acctcounter] = new Account();
    }



}

