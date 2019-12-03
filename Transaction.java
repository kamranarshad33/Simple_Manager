import java.util.Date;

/**
   Defines information related to the process of an account transaction that
   includes the amount, date, and category.
*/
public class Transaction{
    // Dollar amount of the transactions
    private double amount;
    // Date transaction takes place
    private String transDate; //date needed for search
    // Type of transaction that either deposits or withdraws funds
    private String transType;
    // Category of transaction
    private String transCategory;

    //This ensues that the correct account is attached
    private int Attached_Account;
    
    /**
      Constructor for Transaction class that instantiates Transaction object.
      @param transType transaction type
      @param transCategory transaction category
      @param amount transaction amount
     // @param transDate transaction date
    */
    public Transaction(String transType,String transCategory, double amount, String TransDate, int acctnum) {
        this.amount = amount;
        this.transDate = TransDate;
        this.transType = transType;
        this.transCategory = transCategory;
        this.Attached_Account = acctnum;

    }
    public Transaction(String transType,String transCategory, double amount, String TransDate) {
        this.amount = amount;
        this.transDate = TransDate;
        this.transType = transType;
        this.transCategory = transCategory;

    }
    
    /**
      Returns amount of the transaction.
      @return transaction amount
    */
    public double getAmount(){
        return this.amount;    
    }
    
    /**
      Sets the amount of the transaction and ensures the amount is a valid number.
    //  @param amount transaction amount
    */
    public void setAmount(double amount){
        if(amount >= 0){ 
            this.amount = amount;
        }
        else{
            throw new IllegalArgumentException("The transaction amount cannot be negative.");
        }    
    }
    
    /**
      Returns date of the transaction.
      @return transaction date
    */
    public String getDate() {
      return this.transDate;
    }



    /**
      Sets date of transaction using date formatting.
     // @param userDate transaction date
    */
    public void setDate(Date userDate) {
        // formats date to String = MM/DD/YY
        transDate = String.format("%tD", userDate);
    }

    /**
     Returns the account to which the transactions belong.
     @return Account Number for the transaction
     */
    public int getTransAccount() {
        return this.Attached_Account;
    }

    /**
     Sets the Account number attached.
    // @param Account_Attached category
     */
    public void setAccount(int account_attached) {
        this.Attached_Account = account_attached;
    }
    
    /**
      Returns type of transaction.
      @return transaction type
    */
    public String getTransType() {
      return transType;
    }
    
    /**
      Sets the type of tranactions and ensures valid transaction type input.
      //@param type transaction type
    */
    public void setTransType(String type) {
      if (type.trim().equalsIgnoreCase("deposit") || type.trim().equalsIgnoreCase("withdrawal")) {
         this.transType = type;
      }
      else {
         throw new IllegalArgumentException("Error: Deposit and withdrawal are only options.");
      }
    }

    /**
      Returns the category of the transaction.
      @return transaction category
    */
    public String getTransCategory() {
        return transCategory;
    }
    
    /**
      Sets the category of the transaction.
     // @param transaction category
    */
    public void setTransCategory(String transCategory) {
        this.transCategory = transCategory;
    }

    /**
      Returns String of aggregated transaction information.
      @return overall transaction information
    */
    public String toString() {
      return getDate() + " | " + getTransType() + " | " + getTransCategory() + " | $" + getAmount();
    }
}  
