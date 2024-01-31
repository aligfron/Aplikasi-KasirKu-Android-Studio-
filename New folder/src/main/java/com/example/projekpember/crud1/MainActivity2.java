package com.example.projekpember.crud1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.MenuItem;
import android.widget.ListView;

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
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener;
import java.util.List;

@SuppressLint("NewApi")
public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private static final String TAG = "MainActivity2";
    private ListView listView;
    private ActionMode actionMode;
    private ActionMode.Callback amCallback;
    private ProgressDialog progressDialog;
    private ServerRequest serverRequest;
    private List<Barang> list;
    private ListAdapterBarang adapter;
    private Barang selectedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serverRequest = new ServerRequest();
        listView = (ListView) findViewById(R.id.listview_main);
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
        switch (item.getItemId()) {
            case R.id.nav_laporan:
                Intent intent = new Intent(MainActivity2.this, Laporan.class);
                startActivity(intent);
                break;
            case R.id.nav_tentang_kami:
                Intent intent1 = new Intent(MainActivity2.this, Tentangkami.class);
                startActivity(intent1);
                break;
            case R.id.nav_logout:
                Intent intent2 = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_settings:
                Intent intent3 = new Intent(MainActivity2.this, Tambahbarang.class);
                startActivity(intent3);
                break;
            case R.id.nav_account:
                Intent intent4 = new Intent(MainActivity2.this, Riwayattr.class);
                startActivity(intent4);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
