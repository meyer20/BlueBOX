package com.bluebox;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private BluetoothAdapter bluetooth = null;
    private String connectedDevice = null;
    private boolean blueBoxPaired = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bluetooth = BluetoothAdapter.getDefaultAdapter();
        boolean bluetoothIsOn = false;

        Button button = (Button) findViewById(R.id.button);

        if (bluetooth == null) {
            Toast.makeText(getApplicationContext(), "O Bluetooth não está disponivel neste dispositivo.", Toast.LENGTH_LONG).show();
            finish();
        } else {
            if (!bluetooth.isEnabled()) {
                Intent turnBTon = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(turnBTon, 1);
            } else {
                bluetoothIsOn = true;
                Set<BluetoothDevice> pairedDevices = bluetooth.getBondedDevices();

                if (pairedDevices.size() > 0) {
                    for (BluetoothDevice device : pairedDevices) {
                        if (device.getName().equals("HC-05")) {
                            connectedDevice = device.getName();
                            blueBoxPaired = true;
                        }
                    }
                }
            }
        }

        final boolean finalBluetoothIsOn = bluetoothIsOn;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (finalBluetoothIsOn) {
                if (blueBoxPaired) {
                    Toast.makeText(getApplicationContext(), "Uma BlueBOX já foi pareada neste dispositivo. Aguarde, a conexão está em andamento.", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), TextActivity.class);
                    startActivityForResult(i, 100);
                } else {
                    Intent i = new Intent(getApplicationContext(), notConnected.class);
                    startActivityForResult(i, 100);
                }
            } else {
                Intent i = new Intent(getApplicationContext(), notConnected.class);
                startActivityForResult(i, 100);
            }
            }
        });
    }
}
