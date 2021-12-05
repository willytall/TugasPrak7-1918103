package com.example.tugasprak7_1918103;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Ejadwal, Etim;
    private String Sjadwal, Stim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Ejadwal = (EditText) findViewById(R.id.create_jadwal);
        Etim = (EditText) findViewById(R.id.create_tim);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjadwal = String.valueOf(Ejadwal.getText());
                Stim = String.valueOf(Etim.getText());
                if (Sjadwal.equals("")){
                    Ejadwal.requestFocus();
                    Toast.makeText(MainCreate.this, "silakan isi jadwal",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Stim.equals("")) {
                    Etim.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi tim",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Ejadwal.setText("");
                    Etim.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateJadwal(new Jadwal(null, Sjadwal,
                            Stim));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}