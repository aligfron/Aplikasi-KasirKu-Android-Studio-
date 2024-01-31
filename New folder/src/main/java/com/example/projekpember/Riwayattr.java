package com.example.projekpember;

    import android.content.Intent;
    import android.os.Bundle;
    import android.os.Message;
    import android.view.Gravity;
    import android.view.MenuItem;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ImageButton;
    import android.widget.TableLayout;
    import android.widget.Toast;
    import com.example.projekpember.kasir.crud.kasir1;
    import androidx.activity.result.contract.ActivityResultContracts;
    import androidx.annotation.NonNull;
    import androidx.appcompat.app.ActionBarDrawerToggle;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.view.GravityCompat;
    import androidx.drawerlayout.widget.DrawerLayout;

    import com.example.projekpember.crud1.DetailBarang;
    import com.example.projekpember.crud1.MainActivity2;
    import com.example.projekpember.crud1.Tambahbarang;
    import com.example.projekpember.laporan.Laporan;
    import com.google.android.material.navigation.NavigationView;

    import org.json.JSONArray;

    import java.util.ArrayList;

public class Riwayattr extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Biodata biodata = new Biodata();
    TableLayout tabelBiodata;
    EditText TextKembalian,TextJumlahharga,TextTotal;
    ImageButton buttonTambahBiodata,buttonhitung,buttonhapus,buttonlaporan;
    ArrayList<Button> buttonEdit = new ArrayList<Button>();
    ArrayList<Button> buttonDelete = new ArrayList<Button>();

    JSONArray arrayBiodata;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);


            buttonlaporan = (ImageButton) findViewById(R.id.imageButton);
            buttonlaporan.setOnClickListener(new View.OnClickListener() {

                                                 public void onClick(View view) {
                                                     // TODO Auto-generated method stub

                                                     Intent a = new Intent(Riwayattr.this, kasir1.class);
                                                     startActivity(a);
                                                     finish();

                                                 }
                                                 });



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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_laporan:
                Intent intent = new Intent(Riwayattr.this,Laporan.class);
                startActivity(intent);
                break;
            case R.id.nav_tentang_kami:
                Intent intent1 = new Intent(Riwayattr.this,Tentangkami.class);
                startActivity(intent1);
                break;
            case R.id.nav_logout:
                Intent intent2 = new Intent(Riwayattr.this,MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_settings:
                Intent intent3 = new Intent(Riwayattr.this, Tambahbarang.class);
                startActivity(intent3);
                break;
            case R.id.nav_atur_barang:
                Intent intent4 = new Intent(Riwayattr.this, MainActivity2.class);
                startActivity(intent4);
                break;



        }
        drawerLayout.closeDrawer(GravityCompat.START);
            return true;
    }

    public void onBackPressed(){

        finish();
    }

}
