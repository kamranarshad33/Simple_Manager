/**
   The SavingAcc class is defined as a savings account type
   inherited from the parent Account class.
*/
public class SavingAcc extends Account {
    
    // Type of account
    private String Accttype;
   
    /**
      Constructor for SavingAcc class that instantiates a SavingAcc object.
      @param accttype type of account
      @param bankname name of bank
      @param routing routing number of checking account
      @param balance checking account balance
    */
    public SavingAcc(String accttype, String bankname, String routing, double balance){
        super(accttype,bankname,routing,balance);
        // Assigns account type to be savings account
        this.Accttype= "Saving Account" ;
    }

}
