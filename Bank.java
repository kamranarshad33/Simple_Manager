

import java.util.*;

//linkedlist and/or arraylist
public class Bank extends Account {

    private Account[] bankAccs = new Account[10];
    private int maxacct = 10;
    private static int acctcounter = 0;


    private Bank() {
        //initialize data structures
        bankAccs[acctcounter] = new Account();
    }



}

