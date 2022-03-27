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
    EditText textnama, textemail, textpassw, textrepass;

    //Deklarasi variabel dengan tipe data button action button
    Button Bsimpan;
    String name; //untuk menerima nama

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_activity);
        textnama = findViewById(R.id.edNama);
        textemail = findViewById(R.id.edEmail2);
        textpassw = findViewById(R.id.edPass);
        textrepass = findViewById(R.id.edrepas);
        Bsimpan = findViewById(R.id.buttonSave);

        //membuat method untuk event dari button
        Bsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = textnama.getText().toString();

                if (textnama.getText().toString().length() == 0)
                    textnama.setError("Nama belum diinput");
                else if (textemail.getText().toString().length() == 0)
                    textemail.setError("Email belum diinput");
                else if (textpassw.getText().toString().length()==0)
                    textpassw.setError("Password belum diinput");
                else if (textrepass.getText().toString().length() == 0)
                    textrepass.setError("Re-Password belum diinput");
                else
                {
                    //Membuat kondisi untuk mengecek apakah isi dari password dan repassword sama atau tidak
                    if (textpassw.getText().toString().equals(textrepass.getText().toString()))
                    {
                        //inisiasi
                        Bundle bn = new Bundle();
                        //memasukkan value dari variabel nama dengan kunci "b" dan dimasukkan ke dalam bundle
                        bn.putString("b", name.trim());

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
                        Snackbar.make(v, "Password Tidak Sama", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}