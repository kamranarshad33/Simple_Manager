
public class CheckinAcc extends Account{


    private String Accttype;

    public CheckinAcc(String accttype, String bankname, String routing, double balance){
        super(accttype,bankname,routing,balance);
        this.Accttype= "Checking Account" ;
    }




}