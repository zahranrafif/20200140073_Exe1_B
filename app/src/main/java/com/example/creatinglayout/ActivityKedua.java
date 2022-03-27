package com.example.creatinglayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ActivityKedua extends AppCompatActivity {
    //mendeklarasikan variabel dengan tipe data TextView
    TextView txEmail, enama;

    //deklrasi variabel untuk EditText
    EditText ktask, kjtask, kttask;

    //deklarasi variabel untuk menyimpan (task jtask ttask)
    String task, jenisT, timeT;

            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                //Method untuk menampilkan menu.
                getMenuInflater().inflate(R.menu.menu, menu);
                return super.onCreateOptionsMenu(menu);
            }

            @Override
            public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                //Membuat kondisi jika dipilih adalah
                if (item.getItemId() == R.id.simpan)
                {
                    //Method untuk memanggil activity Result.class
                    Intent i = new Intent(getApplicationContext(), Result.class);
                    startActivity(i);
                }
                else if (item.getItemId() == R.id.mlogout)
                {
                    //Method untuk memanggil activity ActivityKedua

                    finish();
                }
                return super.onOptionsItemSelected(item);
            }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        //menghubungkan variabel edtask1,edjenisTask1, edtimetask1 dengan componen button pada layout
        ktask=findViewById (R.id.edtask);
        kjtask= findViewById(R.id.edjenisTask);
        kttask= findViewById(R.id.edtimetask);

        //Menghubungkan variabel txEmail, enama dengan componen TextView pada Layout
        txEmail = findViewById(R.id.hEmail);
        enama = findViewById(R.id.hEmail2);

        //membuat objek bundle dan mengambil data yang dikirimkan dari activity sebelumnya
        Bundle bundle = getIntent().getExtras();

        //Membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan dari activity sebelumnya dengan kunci "a" dan kunci "b".
        String email = bundle.getString("a");
        String edtNama = bundle.getString("b");

        //menampilkan value dari variabel email kedalam txEmail
        txEmail.setText(email);
        //menampilkan value dari variabel edtNama kedalam enama
        enama.setText(edtNama);

        FloatingActionButton fab = findViewById(R.id.simpan);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = ktask.getText().toString();
                jenisT = kjtask.getText().toString();
                timeT = kttask.getText().toString();

                ktask.setError("Task Diperlukan");
                kjtask.setError("Jenis Task Diperlukan");
                kttask.setError("Time Task Diperlukan");

                    Bundle bn = new Bundle();

                    //memasukkan value dari variabel nama dengan kunci "a" dan dimasukkan kedalam bundle
                    bn.putString("a", task.trim());

                    //memasukkan value dari variabel password dengan kunci "b" dan dimasukkan kedalam bundle
                    bn.putString("b", jenisT.trim());

                    //memasukkan value dari variabel password dengan kunci "b" dan dimasukkan kedalam bundle
                    bn.putString("c", timeT.trim());

                    //membuat objek intent berpindah activity ke ActivityKedua
                    Intent i = new Intent(getApplicationContext(),Result.class);

                    //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityKedua
                    i.putExtras(bn);

                    //berpindah ke ActivityKedua
                    startActivity(i);
            }

        });
    }
}



















