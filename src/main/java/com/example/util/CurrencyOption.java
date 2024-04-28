package com.example.util;

public class CurrencyOption {
    private String firstChoice;
    private String secondChoice;


    public void optionSelected(int from, int to){
        String[] options = {"BRL","USD","EUR","CHF","CAD","GBP"};

        for (int i = 0; i < options.length; i++) {
            if(from == i + 1)setFirstChoice(options[i]);;
            if( to == i + 1)setSecondChoice(options[i]);;
        }       
    }
    
    public String getFirstChoice() {
        return firstChoice;
    }

    public void setFirstChoice(String firstChoice) {
        this.firstChoice = firstChoice;
    }

    public String getSecondChoice() {
        return secondChoice;
    }

    public void setSecondChoice(String secondChoice) {
        this.secondChoice = secondChoice;
    }
}
