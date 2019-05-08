package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NatureOf {
    ArrayList<String> theraTalk = new ArrayList<>();
    String[] positive = {"good", "glad", "happy", "relaxed", "accomplished", "alert", "creative", "interesting", "love"};
    String[] negative = {"bad", "sad", "tired", "angry", "anxious", "hungry", "moody", "afraid", "hate"};
    ArrayList<String>sarcTalk = new ArrayList<>();//List of sarcastic comebacks
    ArrayList<String>posTalk = new ArrayList<>();//List of interested answers
    ArrayList<String>borTalk = new ArrayList<>();//List of bored answers
    Record record = new Record();
    Invoice session = new Invoice();

    //Runs the Raven Program
    public void runApp(){
        Scanner input = new Scanner(System.in);
        String answer;
        String answer1;

        System.out.println("Before we begin, what is you name: ");
        session.setName(input.nextLine());

        System.out.println("What is your address (Street number + street name)? ");
        session.addAddress(input.nextLine());

        System.out.println("Please enter the city, State, Zipcode: ");
        session.addAddress(input.nextLine());

        System.out.println("\n\nSo, what's going on?(Press Q to quit!)");
        answer = input.nextLine();

        while (!answer.equalsIgnoreCase("Q")) {

            analyzeThis(answer);
            session.addQuestion(answer);
            answer = input.nextLine();

        }
        System.out.println("\nDone Already? Goodbye!! ");
        System.out.println("Would you like a copy of the transcript?");
        answer1 = input.nextLine();

        if (answer1.equalsIgnoreCase("Y")) {
            System.out.println(getConvo());

        }
        else{
            System.out.println("\n\nFine but you're still getting an invoice!");
            session.printInvoice();
        }

    }

    //Scans answer for positive or negative words
    public void analyzeThis(String m) {
        record.setRecording("You: " + m);
        int pos = 0;
        int neg = 0;
        String[] strArr = m.split(" ");
        for (int i = 0; i < positive.length; i++) {
            for (int j = 0; j < strArr.length; j++) {
                if (positive[i].equalsIgnoreCase(strArr[j])) {
                    pos++;
                } else if (negative[i].equalsIgnoreCase(strArr[j])) {
                    neg++;
                }
            }
        }
//        System.out.println("positive words count: "+ pos);
//        System.out.println("negative words count: "+ neg);

    //Decides which direction to take
        if (pos > neg) {
            System.out.println(sarcasmOn());
        } else if (neg == pos) {
            System.out.println(interestOff());
        } else {
            System.out.println(interestOn());
        }

    }

    public String sarcasmOn() {
        sarcTalk.add("Wow, congrats! Must be great being you!");
        sarcTalk.add("Yay!!");
        sarcTalk.add("huh, good for you!!!");
        sarcTalk.add("cute!");

        String m = answerGen(sarcTalk, 0);
        recordIt(m);
        return m;
    }

    public String interestOff() {
        borTalk.add("Meh, so not much going on!!!");
        borTalk.add("Yawn...");
        borTalk.add("ok");

        String k = answerGen(borTalk, 0);
        recordIt(k);
        return k;

    }

    public String interestOn() {
        posTalk.add("Ooooh, how interesting...Tell me more!");
        posTalk.add("Go on...");
        posTalk.add("Alright!!! Now we're talking!!!");

        String r = answerGen(posTalk, 0);
        recordIt(r);
        return r;

    }

    public void recordIt(String m) {
        record.setRecording("Raven: " + m);
    }

    public String getConvo() {
        String s= " ";
        theraTalk = record.getRecording();
        System.out.println("\nTranscript: ");

        for (String m : theraTalk) {
            System.out.println(m);
        }

        session.printInvoice();
        return s;
    }

    public String answerGen(ArrayList<String>arr, int num){
        Collections.shuffle(arr);
        return arr.get(num);
    }
}
