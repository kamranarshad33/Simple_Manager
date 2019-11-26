

import java.util.Date;

public class Transaction{
    private double amount;
    private String transDate; //date needed for search
    private String transType;
    private String transCategory;
    
    public Transaction(String transType,String transCategory, double amount, String TransDate) {  
        this.amount = amount;
        this.transDate = TransDate;
        this.transType = transType;
        this.transCategory = transCategory;   
    
    }
    
    public double getAmount(){
        return this.amount;    
    }
    
    public void setAmount(double amount){
        if(amount >= 0){ 
            this.amount = amount;
        }
        else{
            throw new IllegalArgumentException("The transaction amount cannot be negative.");
        }    
    }
    
    public String getDate() {
      return this.transDate;
    }
    
    public void setDate(Date userDate) {
        // formats date to String = MM/DD/YY
        transDate = String.format("%tD", userDate);
    }
    
    public String getTransType() {
      return transType;
    }
    
    public void setTransType(String type) {
      if (type.trim().equalsIgnoreCase("deposit") || type.trim().equalsIgnoreCase("withdrawal")) {
         this.transType = type;
      }
      else {
         throw new IllegalArgumentException("Error: Deposit and withdrawal are only options.");
      }
    }


    public String getTransCategory() {
        return transCategory;
    }

    public void setTransCategory(String transCategory) {
        this.transCategory = transCategory;
    }


    public String toString() {
      return getDate() + " | " + getTransType() + " | $" + getAmount();
    }
}  