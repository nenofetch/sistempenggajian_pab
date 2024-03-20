package com.nenofetch.sistempenggajian;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int gajiStatus, gajiGolongan;

    String checkStatus, displayGolongan;
    RadioButton selectedGolongan;
    RadioGroup golongan;
    CheckBox status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void hitung(View v) {
        EditText nama = (EditText) findViewById(R.id.nama);
        TextView outputNama = (TextView) findViewById(R.id.outputNama);
        String name = nama.getText().toString();
        outputNama.setText("Total Gaji Anda " + name);
        status = (CheckBox) findViewById(R.id.menikah);
        if (status.isChecked()) {
            checkStatus = status.getText().toString();
            gajiStatus = 500000;
        } else {
            gajiStatus
                    = 0;
            checkStatus = "Belum Menikah";
        }
        golongan = (RadioGroup) findViewById(R.id.rgGolongan);
        int gol =
                golongan.getCheckedRadioButtonId();
        if (gol == R.id.rbGolongan1) {
            gajiGolongan = 1000000;
            selectedGolongan = findViewById(gol);
            displayGolongan = selectedGolongan.getText().toString();

        } else if (gol == R.id.rbGolongan2) {
            gajiGolongan =
                    2000000;
            displayGolongan = selectedGolongan.getText().toString();

        }
        ;
        int totalGaji = gajiStatus + gajiGolongan;
        TextView total = (TextView) findViewById(R.id.outputGaji);
        TextView statusMenikah = (TextView) findViewById(R.id.outputStatus);
        TextView statusGolongan = (TextView) findViewById(R.id.outputGolongan);
        total.setText(String.valueOf(totalGaji));
        statusMenikah.setText("Status Anda : " + checkStatus);
        statusGolongan.setText(String.valueOf(displayGolongan));

    }
}