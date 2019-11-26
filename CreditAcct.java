public class CreditAcct extends Account{

    private String Accttype;

    public CreditAcct(String accttype, String bankname, String routing, double balance){
        super(accttype,bankname,routing,balance);
        this.Accttype = "Credit Account" ;
    }


}
