/**
   The CheckinAcc class is defined as a checking account type
   inherited from the parent Account class.
*/
public class CheckinAcc extends Account{

    // Type of account
    private String Accttype;
    
    /**
      Constructor for CheckinAcc class that instantiates a CheckinAcc object.
      @param accttype type of account
      @param bankname name of bank
      @param routing routing number of checking account
      @param balance checking account balance
    */
    public CheckinAcc(String accttype, String bankname, String routing, double balance){
        super(accttype,bankname,routing,balance);
        // Assigns account type to be checking account
        this.Accttype= "Checking Account" ;
    }




}