

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

//linkedlist and/or arraylist
public class User extends Account {

    private Account[] bankAccs = new Account[10];
    private int maxacct = 10;
    private static int acctcounter = 0;


    public User(String accttype, String bankname, String routing, double balance) {
        //initialize data structures
        bankAccs[acctcounter] = new Account(accttype,bankname,routing,balance);
    }


    public void addNewAcct(String accttype, String bankname, String routing, double balance){
        bankAccs[acctcounter] = new Account(accttype,bankname,routing,balance);
    }








}

