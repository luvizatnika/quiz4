package com.luvizatnika1501512.utsmobprog.quiz41501512;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView kodeBayar , jumlahBayar;
    ArrayList<DbBayar.Bayar> alByr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kodeBayar = (TextView) findViewById(R.id.kodeBayar);
        jumlahBayar = (TextView) findViewById(R.id.jumlahBayar);

    }

    DbBayar dbQuiz4;
        /*Button bTambah = (Button) findViewById(R.id.btnTambah);
        bTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert data,

            }
        });*/

    public void onClick(View v) {
        dbQuiz4 = new DbBayar(getApplicationContext());
        dbQuiz4.open();
        dbQuiz4.insertBayar("1","1000");



        //coba cari mhs
        DbBayar.Bayar m = dbQuiz4.getBayar("1");
        Toast.makeText(getApplicationContext(),
                String.format("Kode_Bayar: %s ; Jumlah_Bayar: %s",m.kode_bayar,m.jumlah_bayar), Toast.LENGTH_LONG).show();
    }



    public void onClick1(View v){

        ArrayList<DbBayar.Bayar> alByr= dbQuiz4.getAllBayar();

        for (DbBayar.Bayar byr:alByr) {
            Toast.makeText(getApplicationContext(),
                    String.format("kode_bayar: %s ; jumlah_bayar: %s",byr.kode_bayar,byr.jumlah_bayar), Toast.LENGTH_SHORT).show();
                    //String.format("kode_bayar: %s ; jumlah_bayar: %s",byr.kode_bayar,byr.jumlah_bayar);
        }
    }




    //  Karena membuka database merupakan operasi yang berat, maka database
// harus selama mungkin dibuka. Tutup database di method onDestroy() milik Activity.
    @Override
    protected void onDestroy() {
        dbQuiz4.close();
        super.onDestroy();
    }

}
