package com.example.projekpember.crud1;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.projekpember.MainActivity;
import com.example.projekpember.R;
import com.example.projekpember.Riwayattr;
import com.example.projekpember.Tentangkami;
import com.example.projekpember.laporan.Laporan;
import com.google.android.material.navigation.NavigationView;



@SuppressLint("NewApi")  public class Tambahbarang extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private EditText textNama_barang, textMerk, textHarga_beli, textHargajual, textJumlahbarang;
    private ProgressDialog progressDialog;
    private ServerRequest server;
    private int replyCode;
    private Barang siswa;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbh_barang);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    private void initView(){
        textNama_barang = (EditText) findViewById(R.id.addnama);
        textMerk = (EditText) findViewById(R.id.addmerk);
        textHarga_beli = (EditText) findViewById(R.id.addhargabeli);
        textHargajual = (EditText) findViewById(R.id.addhargajual);
        textJumlahbarang = (EditText) findViewById(R.id.addjumlah);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;

        }


        switch(item.getItemId()){


            case R.id.option_menu_save:
                if(textNama_barang.getText().toString().trim().isEmpty() || textMerk.getText().toString().trim().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Nama barang dan Merk tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else{
                    new FormSiswaAsync().execute();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_laporan:
                Intent intent = new Intent(Tambahbarang.this, Laporan.class);
                startActivity(intent);
                break;
            case R.id.nav_tentang_kami:
                Intent intent1 = new Intent(Tambahbarang.this, Tentangkami.class);
                startActivity(intent1);
                break;
            case R.id.nav_logout:
                Intent intent2 = new Intent(Tambahbarang.this, MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_account:
                Intent intent3 = new Intent(Tambahbarang.this,Riwayattr.class);
                startActivity(intent3);
                break;
            case R.id.nav_atur_barang:
                Intent intent4 = new Intent(Tambahbarang.this, MainActivity2.class);
                startActivity(intent4);
                break;



        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.form_barang, menu);
        return true;
    }


    private class FormSiswaAsync extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(Tambahbarang.this);
            progressDialog.setMessage("saving data...");
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }


    }


}
