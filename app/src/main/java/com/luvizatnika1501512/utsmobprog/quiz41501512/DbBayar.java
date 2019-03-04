package com.luvizatnika1501512.utsmobprog.quiz41501512;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DbBayar {

    public static class Bayar{
        public String kode_bayar;
        public String jumlah_bayar;
    }


    private SQLiteDatabase db;
    private final OpenHelper dbHelper;

    public DbBayar(Context c) {
        dbHelper =  new OpenHelper(c);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public long insertBayar(String kode_bayar, String jumlah_bayar) {
        ContentValues newValues = new ContentValues();
        newValues.put("KODE_BAYAR", kode_bayar);
        newValues.put("JUMLAH_BAYAR", jumlah_bayar);
        return db.insert("BAYAR", null, newValues);
    }

    //ambil data mahasiswa berdasarkan nama
    public Bayar getBayar(String kode_bayar) {
        Cursor cur = null;
        Bayar M = new Bayar();

        //kolom yang diambil
        String[] cols = new String [] {"ID", "KODE_BAYAR", "JUMLAH_BAYAR"};
        //parameter, akan mengganti ? pada NAMA=?
        String[] param  = {kode_bayar};

        cur = db.query("BAYAR",cols,"KODE_BAYAR=?",param,null,null,null);

        if (cur.getCount()>0) {  //ada data? ambil
            cur.moveToFirst();
            M.kode_bayar = cur.getString(1);
            M.jumlah_bayar = cur.getString(2);
        }
        cur.close();
        return M;
    }

    public ArrayList<Bayar> getAllBayar() {
        Cursor cur = null;
        ArrayList<Bayar> out = new ArrayList<>();
        cur = db.rawQuery("SELECT kode_bayar,jumlah_bayar FROM Bayar Limit 10", null);
        if (cur.moveToFirst()) {
            do {
                Bayar byr = new Bayar();
                byr.kode_bayar = cur.getString(0);
                byr.jumlah_bayar = cur.getString(1);
                out.add(byr);
            } while (cur.moveToNext());
        }
        cur.close();
        return out;
    }



}
