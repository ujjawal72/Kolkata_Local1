package com.example.login_activity.Database;

import java.util.ArrayList;
import java.util.List;

public class DataClassForDatabase {
    private List<String> trainName;
    private List<String> arrTime;
    private List<String> depTime;
    private List<String> trainNumber;

    public DataClassForDatabase() {
        trainNumber = new ArrayList<>();
        trainName = new ArrayList<>();
        arrTime = new ArrayList<>();
        depTime = new ArrayList<>();
    }

    void addTrain(String trainName){
        this.trainName.add(trainName);
    }
    void addArrTime(String arrTime){
        this.arrTime.add(arrTime);
    }
    void addDepTime(String depTime){
        this.depTime.add(depTime);
    }
    void addTrainNumber(String trainNumber){
        this.trainNumber.add(trainNumber);
    }

    public List<String > getTrainNames(){
        return trainName;
    }
    public List<String > getArrTimes(){
        return arrTime;
    }
    public List<String> getDepTimes(){
        return depTime;
    }
    public List<String > getTrainNumbers(){
        return trainNumber;
    }
}
