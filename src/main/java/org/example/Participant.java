package org.example;

public class Participant {
    private String name;
    private double balance;
    private boolean providedHelp;

    public Participant(String name, double initialBalance){
        this.name = name;
        this.balance = initialBalance;
        this.providedHelp = false;
    }

    public String getName(){
        return name;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public boolean hasProvidedHelp(){
        return providedHelp;
    }

    public void setProvidedHelp(boolean providedHelp){
        this.providedHelp = providedHelp;
    }
}
