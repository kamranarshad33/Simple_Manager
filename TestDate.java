/**
   Testing if date can be implemented for transactions and transaction searches.
*/

import java.util.*;

public class TestDate {
   
   public static void main(String[] args) {
      
      // Create Date Object class in java.util
      Date d1 = new Date();
      
      // Can covert dates to Strings but prints out date + time
      //String date = d1.toString();  
      //System.out.print(date); 
            
      // Takes Date object and formats to MM/DD/YY format
      System.out.println(String.format("%tD",d1));
      // Works as saving to String
      String strDate = String.format("%tD",d1);
      
      // Testing if can search and retrieve dates
      LinkedList<String> dates = new LinkedList<String>();
      // Seems to successfully add to LinkedList
      dates.add(strDate);
      dates.add("01/01/19");
      System.out.println(dates.size());
      
      // Testing search
      searchDates(dates, "01/01/19");

   }
   
   // Simple search test, was able to find search date within list of dates
   public static void searchDates(LinkedList dates, String search) {
      
      for (Object d : dates) {
         if (d.equals(search)) {
            System.out.println("Date found: " + d);
         }
      }
   }
}