package com.example.tugasprak7_1918103;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Jadwal> ListJadwal = new
            ArrayList<Jadwal>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListJadwal
        );
        mListView = (ListView) findViewById(R.id.List_Jadwal);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListJadwal.clear();
        List<Jadwal> jadwal = db.ReadJadwal();
        for (Jadwal jdwl : jadwal) {
            Jadwal daftar = new Jadwal();
            daftar.set_id(jdwl.get_id());
            daftar.set_jadwal(jdwl.get_jadwal());
            daftar.set_tim(jdwl.get_tim());
            ListJadwal.add(daftar);
            if ((ListJadwal.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Jadwal detailjdwl = (Jadwal)o;
        String Sid = detailjdwl.get_id();
        String Sjadwal = detailjdwl.get_jadwal();
        String Stim = detailjdwl.get_tim();
        Intent goUpdel = new Intent(MainRead.this,
                MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ijadwal", Sjadwal);
        goUpdel.putExtra("Itim",Stim);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListJadwal.clear();
        mListView.setAdapter(adapter_off);
        List<Jadwal> Jadwal = db.ReadJadwal();
        for (Jadwal jdwl : Jadwal) {
            Jadwal daftar = new Jadwal();
            daftar.set_id(jdwl.get_id());
            daftar.set_jadwal(jdwl.get_jadwal());
            daftar.set_tim(jdwl.get_tim());
            ListJadwal.add(daftar);
            if ((ListJadwal.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}