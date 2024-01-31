package com.example.projekpember.kasir.crud;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projekpember.Riwayattr;
import com.example.projekpember.R;
import com.example.projekpember.laporan.Laporan;

public class kasir1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kasirmain);

        String[] karakterMarvel = {"Buku", "Pensil", "Bulpen",
                "Sabun", "Sampo", "Hawkeye", "Spider-Man",
                "Ant-Man", "War Machine", "Captain Marvel", "Doctor Strange",
                "Star-Lord", "Scarlet Witch", "Falcon", "Black Panther",
                "Drax", "Groot", "Valkyrie", "Odin", "Korg", "Winter Soldier",
                "Nick Furry", "Wong", "Loki", "Mighty Thanos"};

        ListView daftar = findViewById(R.id.listview_main1);
        ArrayAdapter<String> adaptor = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, karakterMarvel);
        daftar.setAdapter(adaptor);

        daftar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posisi, long id) {
                switch (posisi) {
                    case 0:
                        Intent intent = new Intent(kasir1.this, detailkasir.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        Intent intent1 = new Intent(kasir1.this, detailkasir.class);
                        startActivity(intent1);
                        break;
                    case 2 :
                        Intent intent2 = new Intent(kasir1.this, detailkasir.class);
                        startActivity(intent2);
                        break;
                    case 3 :
                        Intent intent3 = new Intent(kasir1.this, detailkasir.class);
                        startActivity(intent3);
                        break;
                    case 4 :
                        Intent intent4 = new Intent(kasir1.this, detailkasir.class);
                        startActivity(intent4);
                        break;
                    case 5 :
                        Intent intent5 = new Intent(kasir1.this, detailkasir.class);
                        startActivity(intent5);
                        break;
                }
            }
        });
    }
    public void onBackPressed(){
        Intent a = new Intent(kasir1.this, Riwayattr.class);
        startActivity(a);
        finish();
    }
}





