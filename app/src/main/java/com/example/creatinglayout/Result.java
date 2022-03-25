package com.example.creatinglayout;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    //mendeklarasikan variabel dengan tipe data TextView
    TextView HTask,HTask1,HTask2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_activity); //ini buat nyambungin

        //Menghubungkan variabel txEmail dengan componen TextView pada Layout
        HTask = findViewById(R.id.iniHasil);
        HTask1 = findViewById(R.id.inijenis);
        HTask2 = findViewById(R.id.iniWaktu);

        //membuat objek bundle dan mengambil data yang dikirimkan dari activity sebelumnya
        Bundle bundle = getIntent().getExtras();

        //Membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan dari activity sebelumnya dengan kunci "a"
        String task = bundle.getString("a");
        String task2 = bundle.getString("b");
        String task3 = bundle.getString("c");

        //menampilkan value dari variabel email kedalam txEmail
        HTask.setText(task);
        HTask1.setText(task2);
        HTask2.setText(task3);
    }
}