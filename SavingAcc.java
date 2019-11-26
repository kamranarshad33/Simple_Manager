public class SavingAcc extends Account {

    private String Accttype;

    public SavingAcc(String accttype, String bankname, String routing, double balance){
        super(accttype,bankname,routing,balance);
        this.Accttype= "Saving Account" ;
    }

}
