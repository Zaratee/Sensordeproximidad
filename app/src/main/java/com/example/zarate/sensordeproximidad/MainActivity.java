package com.example.zarate.sensordeproximidad;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.text.Layout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    RelativeLayout Lay ;
    SensorManager sm;
    Sensor sensorr;
    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lay = (RelativeLayout) findViewById(R.id.Layout_1);
        texto = (TextView) findViewById(R.id.txtV_1);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorr = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this,sensorr,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        String text = String.valueOf(sensorEvent.values[0]);
        texto.setText(text);
        float num = Float.parseFloat(text);
        if(num == 0) {
            Lay.setBackgroundColor(Color.RED);
        }else{
            Lay.setBackgroundColor(Color.BLUE);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
