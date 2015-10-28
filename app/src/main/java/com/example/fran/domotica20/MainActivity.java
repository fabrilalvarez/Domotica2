package com.example.fran.domotica20;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static int clic = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        SeekBar sk = (SeekBar) findViewById(R.id.seekBar);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seleccionBarra = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast tostada = Toast.makeText(getApplicationContext(), String.valueOf(progress), Toast.LENGTH_SHORT);
                tostada.show();
                seleccionBarra = progress;
                // mientras voy cambiando me lo da
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // mientras muevo la barrita me da el primer valor en el que estaba
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // cuando suelto la barrita me da el valor
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clic_Boton(View view) {
        Button boton1 = (Button) findViewById(R.id.botoncete);
        if (clic == 0) {
            Toast tostada = Toast.makeText(getApplicationContext(), R.string.boton_apagado, Toast.LENGTH_SHORT);
            tostada.show();
            boton1.setText(R.string.boton_apagado);
            clic = 1;
        } else {
            Toast tostada = Toast.makeText(getApplicationContext(), R.string.boton_encendido, Toast.LENGTH_SHORT);
            tostada.show();
            boton1.setText(R.string.boton_encendido);
            clic = 0;
        }
    }

}
