package com.example.login_activity.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private DatabaseHelper openHelper;
    private SQLiteDatabase database;


    public Database(Context context) {

        openHelper = new DatabaseHelper(context);

    }

    public void openDB() {
        this.database = openHelper.getWritableDatabase();
    }

    public void closeDB() {
        if (database != null) {
            database.close();
        }
    }

    public DataClassForSingleTrain getSingleTrain(String tableName){
        DataClassForSingleTrain singleTrain = new DataClassForSingleTrain();
        Cursor cr = database.rawQuery("select * from '"+tableName+"'",null);
        while (cr.moveToNext()){

            singleTrain.addArrivalTime(cr.getString(cr.getColumnIndex("ARRIVAL")));
            singleTrain.addDepartureTime(cr.getString(cr.getColumnIndex("DEPARTURE")));
            singleTrain.addStationName(cr.getString(cr.getColumnIndex("STATION")));

        }
        cr.close();
        return singleTrain;
    }

    public String getTrainDirection(String source, String destination) {

        Cursor cursor = database.rawQuery("SELECT * FROM 'STATION_NAME'", null);
        int ID = -1;
        while (cursor.moveToNext()) {
            String src = cursor.getString(1); //STATION NAME
            if (source.equals(src)) {
                ID = Integer.parseInt(cursor.getString(0));
                break;
            }
        }
        if (ID != -1) {
            cursor.moveToFirst();
            do {
                String des = cursor.getString(1);
                if (destination.equals(des)) {
                    if (ID < Integer.parseInt(cursor.getString(0))) {
                        cursor.close();
                        return "UP";
                    } else if (ID > Integer.parseInt(cursor.getString(0))) {
                        cursor.close();
                        return "DOWN";
                    }
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return "Not Found";
    }

    public DataClassForDatabase getTrains(String source, String destination) {
        DataClassForDatabase dataClass = new DataClassForDatabase();

        Cursor cursor;
        int id = -1;
        String tDirection =getTrainDirection(source,destination);
        if(tDirection.equals("UP")){
            cursor = database.rawQuery("select * from 'ALL_UP_TRAINS'",null);
        }else if(tDirection.equals("DOWN")){
            cursor = database.rawQuery("select * from 'ALL_DOWN_TRAINS'",null);
        }else {
            return null;
        }

        while (cursor.moveToNext()){
            String tableName = cursor.getString(cursor.getColumnIndex("T_NUMBER"));
            Cursor cursor1 = database.rawQuery("select * from '"+tableName+"'",null);

            while (cursor1.moveToNext()){
                String src = cursor1.getString(cursor1.getColumnIndex("STATION"));
                if(source.equals(src)){
                    id = Integer.parseInt(cursor1.getString(0));
                    break;
                }
            }
            if(id != -1){
                cursor1.moveToFirst();
                do{
                    String des = cursor1.getString(cursor1.getColumnIndex("STATION"));
                    if(destination.equals(des) && id < Integer.parseInt(cursor1.getString(0))){

                        dataClass.addTrainNumber(tableName);
                        dataClass.addTrain(cursor.getString(cursor.getColumnIndex("T_NAME")));
                        dataClass.addArrTime(cursor1.getString(cursor1.getColumnIndex("ARRIVAL")));
                        dataClass.addDepTime(cursor1.getString(cursor1.getColumnIndex("DEPARTURE")));

                    }
                }while (cursor1.moveToNext());
                id = -1;
            }
            cursor1.close();
        }

        cursor.close();
        return dataClass;



    }
}
