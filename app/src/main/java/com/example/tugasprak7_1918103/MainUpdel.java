package com.example.tugasprak7_1918103;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Sjadwal, Stim;
    private EditText Ejadwal, Etim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sjadwal = i.getStringExtra("Ijadwal");
        Stim = i.getStringExtra("Itim");
        Ejadwal = (EditText) findViewById(R.id.updel_jadwal);
        Etim = (EditText) findViewById(R.id.updel_tim);
        Ejadwal.setText(Sjadwal);
        Etim.setText(Stim);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjadwal = String.valueOf(Ejadwal.getText());
                Stim = String.valueOf(Etim.getText());
                if (Sjadwal.equals("")){
                    Ejadwal.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jadwal",
                            Toast.LENGTH_SHORT).show();
                } else if (Stim.equals("")){
                    Etim.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi tim",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateJadwal(new Jadwal(Sid, Sjadwal,
                            Stim));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteJadwal(new Jadwal(Sid, Sjadwal,
                        Stim));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
