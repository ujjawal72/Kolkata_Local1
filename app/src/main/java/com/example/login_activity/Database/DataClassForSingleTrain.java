package com.example.login_activity.Database;

import java.util.ArrayList;
import java.util.List;

public class DataClassForSingleTrain {
    private List<String> arrivalTime;
    private List<String> departureTime;
    private List<String> stationName;

    public DataClassForSingleTrain() {
        arrivalTime = new ArrayList<>();
        departureTime = new ArrayList<>();
        stationName = new ArrayList<>();
    }

    public void addArrivalTime(String arr){
        this.arrivalTime.add(arr);
    }

    public void addDepartureTime(String dep){
        this.departureTime.add(dep);
    }

    public void addStationName(String station){
        this.stationName.add(station);
    }

    public List<String> getArrivalTime(){
        return arrivalTime;
    }

    public List<String> getDepartureTime(){
        return departureTime;
    }

    public List<String> getStationName(){
        return stationName;
    }
}
