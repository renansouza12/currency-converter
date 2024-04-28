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

        System.out.println("""

                                                                    ---------                                           --------
                                                                            W E L C O M E
                            ---------                                                 ---------

                """);

                displayMessage("CONVERT FROM...");
                int from = sc.nextInt();
                displayMessage("TO...");
                int to = sc.nextInt();

                option.optionSelected(from, to);
                
                api.setFirstOption(option.getFirstChoice());
                api.setSecondOption(option.getSecondChoice());

                data.setFirstChoose(api.getFirstOption());
                data.setSecondChoose(api.getSecondOption());
                data.setAmount(1);

                var result = new CurrencyResult(data.getBaseCode(), data.getTargetCode(), data.getConversionRate(), data.getAmount());
                result.displayResutl();

                
        // var c = new CurrencyApi();
        // System.out.println("First Option: ");
        // c.setFirstOption("eur");
        // System.out.println("Second Option");
        // c.setSecondOption("brl");

        // var data = new CurrencyData();

        // data.setFirstChoose(c.getFirstOption());
        // data.setSecondChoose(c.getSecondOption());
        // data.setAmount(1);
        // data.getData();    

        // var result = new CurrencyResult(data.getBaseCode(),data.getTargetCode(),data.getConversionRate(),data.getAmount());
        // result.displayResutl();
        
    }

    private static void displayMessage(String message){
         System.err.printf("""

                        ------
                %s
        -----        
                    1 = BRL -> Brazilian Real          4 = CHF -> Swiss Franc 
                    
                    2 = USD -> Dollar                  5 = CAD -> Canadian Dollar       0 = Exit -> to Stop the program

                    3 = EUR -> Euro                    6 = GBP -> Britsh Pound

        Enter your option :            
                 """,message);   
    }

}