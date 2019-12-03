/**
   The CreditAcct class is defined as a credit account type
   inherited from the parent Account class.
*/
public class CreditAcct extends Account{

    // Type of account
    private String Accttype;

    /**
      Constructor for CreditAcct class that instantiates a CreditAcct object.
      @param accttype type of account
      @param bankname name of bank
      @param routing routing number of checking account
      @param balance checking account balance
    */
    public CreditAcct(String accttype, String bankname, String routing, double balance){
        super(accttype,bankname,routing,balance);
        // Assigns account type to be credit account
        this.Accttype = "Credit Account" ;
    }


}
