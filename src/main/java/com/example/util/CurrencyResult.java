package com.example.util;

public class CurrencyResult {
    private String baseCode;
    private String targetCode;
    private double conversionRate;
    private int amount;
    

    public CurrencyResult(String baseCode,String targetCode ,double conversionRate,int amount){
            this.baseCode = baseCode;
            this.targetCode = targetCode;
            this.conversionRate = conversionRate;
            this.amount = amount;
    } 

    public void displayResutl(){
        double result = getAmount() * getConversionRate();

        System.out.printf("""

                                                                            | |      | |      | |
                                                                    |  |  |     |   |   |   |     |
                                                                   |    |         |       |        |
                                                                |                                    | 
                                                               |     %d %s equals to                   |
                                                              |                                    
                                                        |                        %.2f %s                 |   
                                                |       |   |                                           |  |     | 
                                             |  |   |   |   |    ----------------------------------     |  |  |  |  |
                """,getAmount(),getBaseCode(),result,getTargetCode());
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public int getAmount() {
        return amount;
    }
}
