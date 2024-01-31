package com.example.projekpember.laporan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.projekpember.MainActivity;
import com.example.projekpember.crud1.DetailBarang;
import com.example.projekpember.crud1.MainActivity2;
import com.example.projekpember.crud1.Tambahbarang;
import com.example.projekpember.R;
import com.example.projekpember.Riwayattr;
import com.example.projekpember.Tentangkami;
import com.google.android.material.navigation.NavigationView;

public class Laporan extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laporan);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_account:
                Intent intent = new Intent(Laporan.this,Riwayattr.class);
                startActivity(intent);
                break;
            case R.id.nav_tentang_kami:
                Intent intent1 = new Intent(Laporan.this, Tentangkami.class);
                startActivity(intent1);
                break;
            case R.id.nav_logout:
                Intent intent2 = new Intent(Laporan.this, MainActivity.class);
                startActivity(intent2);
                break;

            case R.id.nav_settings:
                Intent intent3 = new Intent(Laporan.this, Tambahbarang.class);
                startActivity(intent3);
                break;
            case R.id.nav_atur_barang:
                Intent intent4 = new Intent(Laporan.this, MainActivity2.class);
                startActivity(intent4);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

