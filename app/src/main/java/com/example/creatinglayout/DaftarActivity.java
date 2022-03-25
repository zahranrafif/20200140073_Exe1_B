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

public class DaftarActivity extends AppCompatActivity {

    //Deklrasi variabel dengan tipe data EditText
    EditText edtNama, edtEmail, edtPassword, edtepass;

    //Deklarasi variabel dengan tipe data button action button
    Button save;
    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_activity);

        edtNama = findViewById(R.id.edNama);
        edtEmail = findViewById(R.id.edEmail2);
        edtPassword = findViewById(R.id.edPass);
        edtepass = findViewById(R.id.edrepas);
        save = findViewById(R.id.buttonSave);

        //membuat method untuk event dari button
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = edtNama.getText().toString();
                if (edtNama.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtepass.getText().toString().isEmpty())
                {
                    //pesan error jika belum diisi
                    edtNama.setError("Nama Harus diisi");
                    edtEmail.setError("Email Harus diisi");
                    edtPassword.setError("Password Harus diisi");
                    edtepass.setError("Re Password Harus diisi");
                    Snackbar.make(v, "Wajib isi seluruh data !!", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    //Membuat kondisi untuk mengecek apakah isi dari password dan repassword sama atau tidak
                    if (edtPassword.getText().toString().equals(edtepass.getText().toString()))
                    {
                        //inisiasi
                        Bundle bn = new Bundle();

                        //memasukkan value dari variabel nama dengan kunci "b" dan dimasukkan kedalam bundle
                        bn.putString("b", nama.trim());

                        //Menampilkan pesan notifikasi jika Register Sukses
                        Toast.makeText(getApplicationContext(), "Register Sukses",
                                Toast.LENGTH_LONG).show();

                        Intent i = new Intent(getApplicationContext(), ActivityKedua.class);
                        i.putExtras(bn);
                        startActivity(i);
                    }
                    else
                    {
                        //Menampilkan pesan bahwa isi dari EditText password dan EditText repassword tidak sama
                        Snackbar.make(v, "Password Incorrect", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}