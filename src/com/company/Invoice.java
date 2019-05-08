package com.company;

import java.util.ArrayList;

public class Invoice {
    private String name;
    private ArrayList<String> address = new ArrayList<>();
    private ArrayList<String>m = new ArrayList<>();
    private int ask= 0;

    public Invoice(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        String s= "";
        for(String m: address){
            s += m +"\n";
        }
        return s;
    }

    public void addAddress(String m) {
        address.add(m);
    }

    public void printInvoice(){
    //Displays name, address
        System.out.println("\n\nRaven's Invoice\nTo:\n"+ name + "\n" +
        getAddress()+"\n\n");
    //Table of Quantity, Description, Price, Total
        System.out.println("Quantity\tDescription\t\tPrice\t\tTotal");
        System.out.println("1\t\t\tSession\t\t\t100.00\t\t100.00");
        System.out.println(getQuestions()+"\t\t\tQuestions\t\t"+"0.35\t\t"+(0.35 * getQuestions()));

    //Print Total  due on different line
        System.out.println("\nTotal Due: " +(100+(0.35 * getQuestions())));

        System.out.println("\nThank you for doing " +
                "business with Raven");
    }
    public void addQuestion(String m){
        ask++;
    }
    public int getQuestions(){
        return ask;
    }
}
