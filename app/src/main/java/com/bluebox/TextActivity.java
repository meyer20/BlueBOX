package com.bluebox;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Build;
import android.os.ParcelUuid;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TextActivity extends AppCompatActivity {

    public BluetoothAdapter bluetooth = null;
    private OutputStream outputStream;
    private InputStream inStream;
    public EditText textField;
    private SeekBar speedBar;
    private TextView speedView;
    Integer speed = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        bluetooth = BluetoothAdapter.getDefaultAdapter();

        Button button = (Button) findViewById(R.id.button2);
        textField = (EditText)findViewById(R.id.editText);
        speedBar = (SeekBar)findViewById(R.id.speedBar);
        speedView = (TextView)findViewById(R.id.speedViewer);

        ImageView img = (ImageView) findViewById(R.id.imageView2);

        if (bluetooth != null) {
            Set<BluetoothDevice> bondedDevices = bluetooth.getBondedDevices();

            if(bondedDevices.size() > 0) {
                Object[] devices = (Object []) bondedDevices.toArray();
                BluetoothDevice dvc = null;
                for (BluetoothDevice device : bondedDevices) {
                    if (device.getName().equals("HC-05")) {
                        dvc = device;
                        Toast.makeText(getApplicationContext(), "A BlueBox foi conectada!", Toast.LENGTH_LONG).show();
                    }
                }
                ParcelUuid[] uuids = dvc.getUuids();
                BluetoothSocket socket = null;
                try {
                    socket = dvc.createRfcommSocketToServiceRecord(uuids[0].getUuid());
                    socket.connect();
                    outputStream = socket.getOutputStream();
                    inStream = socket.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            Log.e("error", "No appropriate paired devices.");
        }

        speedBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), String.valueOf(progress),Toast.LENGTH_LONG).show();
                speedView.setText(String.valueOf(progress));
                speed = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String textFieldContent = textField.getText().toString().toLowerCase();
                List<String> textList = new ArrayList<String>();

                for (char letter: textFieldContent.toCharArray()) {
                    textList.add(LetterEnum.fromKey(letter).getValue());
                }

                System.out.println(speed);

                try {
                    for (String letra : textList) {
                        write(letra.toString());
                        Thread.sleep(speed * 1000);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), about.class);
                startActivityForResult(i, 100);
            }
        });
    }

    public void write(String s) throws IOException {
        outputStream.write(s.getBytes());
    }

    public void run() {
        final int BUFFER_SIZE = 1024;
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytes = 0;
        int b = BUFFER_SIZE;

        while (true) {
            try {
                bytes = inStream.read(buffer, bytes, BUFFER_SIZE - bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
