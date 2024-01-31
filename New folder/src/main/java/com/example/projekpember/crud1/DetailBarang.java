package com.example.projekpember.crud1;  // activity_detail_siswa


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

@SuppressLint("NewApi") public class DetailBarang extends AppCompatActivity{
	public DrawerLayout drawerLayout;
	public ActionBarDrawerToggle actionBarDrawerToggle;
	private EditText textNama_barang, textMerk, textHarga_beli, textHargajual, textJumlahbarang;
	private Barang siswa;
	private ServerRequest server;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_barang);
		drawerLayout = findViewById(R.id.my_drawer_layout);
		NavigationView navigationView = findViewById(R.id.nav_view);

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



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main_action, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case android.R.id.home:
				goToMainActivity();
				break;

			case R.id.action_menu_edit:
				Intent in = new Intent(getApplicationContext(), DetailBarang2.class);
				/**in.putExtra("id", siswa.getId().toString());
				in.putExtra("nama_barang", siswa.getNama_barang());
				in.putExtra("merk", siswa.getMerk());
				in.putExtra("harga_beli", siswa.getHarga_beli());
				in.putExtra("hargajual", siswa.getHargajual());
				in.putExtra("jumlahbarang", siswa.getJumlahbarang());*/
				startActivity(in);
				break;

			/**case R.id.action_menu_delete:
				delete();
				break;*/
		}
		return super.onOptionsItemSelected(item);
	}
	private void goToMainActivity(){
		Intent in = new Intent(getApplicationContext(), MainActivity2.class);
		in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(in);
	}
}
