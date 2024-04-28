package com.example;

import java.io.IOException;
import java.util.Scanner;

import com.example.api.CurrencyApi;
import com.example.models.CurrencyData;
import com.example.util.CurrencyOption;
import com.example.util.CurrencyResult;

public class Main {
    public static void main(String[] args) throws IOException {
        var api = new CurrencyApi();
        var data = new CurrencyData();
        var option = new CurrencyOption();
        var sc = new Scanner(System.in);

        int answer;

        System.out.println("""



                                                                    ---------                                           --------
                                                                            W E L C O M E
                            ---------                                                 ---------

                """);

        
        do{
        displayMessage("CONVERT FROM...");
        int from = sc.nextInt();
        displayMessage("TO...");
        int to = sc.nextInt();
    
        option.optionSelected(from, to);
          
        if(option.getFirstChoice().equals("EXIT") || option.getSecondChoice().equals("EXIT"))break;
                
        api.setFirstOption(option.getFirstChoice());
        api.setSecondOption(option.getSecondChoice());

        data.setFirstChoose(api.getFirstOption());
        data.setSecondChoose(api.getSecondOption());

        System.out.println("Enter the quantity you wish: ");
        int quantity = sc.nextInt();
        data.setAmount(quantity);
        data.getData();    
        

        var result = new CurrencyResult(data.getBaseCode(),data.getTargetCode(),data.getConversionRate(),data.getAmount());
        result.displayResutl();
        
        System.out.println("""
            Do you wish continue ?: 
            0 - to exit

        """);
        answer = sc.nextInt();
            
        }while(answer != 0);
        
        sc.close();
    }

    private static void displayMessage(String message){
         System.err.printf("""
  


                        ------
                %s
        -----        
                    1 = BRL -> Brazilian Real          4 = CHF -> Swiss Franc 
                    
                    2 = USD -> Dollar                  5 = CAD -> Canadian Dollar   

                    3 = EUR -> Euro                    6 = GBP -> Britsh Pound

        Enter your option :            
                 """,message);   
    }

}