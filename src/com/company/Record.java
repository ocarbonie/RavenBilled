package com.company;

import java.util.ArrayList;

public class Record {
    ArrayList<String>recording = new ArrayList<>();

    public Record(){
    }

    public Record(ArrayList<String> recording) {
        this.recording = recording;
    }

    public ArrayList<String> getRecording() {
        return recording;
    }

    public void setRecording(String m) {
        recording.add(m);
    }
}