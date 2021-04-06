package com.example.sensorslist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showListOfSensors();
    }

    private void showListOfSensors() {
        ListView listView = findViewById(R.id.sensorsNamesList);
        List<Sensor> sensorList = getSensorList();
        List sensorsNameList =  getSensorNamesList(sensorList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                sensorsNameList);
        listView.setAdapter(adapter);
    }

    private List getSensorNamesList(List<Sensor> sensorList) {
        List<String> sensorsNameList = new ArrayList<String>();
        for(Sensor s : sensorList)
            sensorsNameList.add(s.getName());
        return sensorsNameList;
    }

    private List<Sensor> getSensorList() {
        SensorManager sensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);
        return  sensorManager.getSensorList(Sensor.TYPE_ALL);
    }
}
