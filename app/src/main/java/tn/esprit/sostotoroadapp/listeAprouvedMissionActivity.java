package tn.esprit.sostotoroadapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import tn.esprit.sostotoroadapp.Adapter.MyAdapter;
import tn.esprit.sostotoroadapp.Adapter.MyAdapter2;
import tn.esprit.sostotoroadapp.database.AppDataBase;

public class listeAprouvedMissionActivity extends AppCompatActivity {
    private AppDataBase dataBase;
    private RecyclerView recyclerView4;
    private Button adbtnhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_aprouved_mission);
        dataBase = AppDataBase.getAppDataBAse(this);
        recyclerView4 = findViewById(R.id.recyclerView4);
        recyclerView4.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView4.setAdapter(new MyAdapter2(this,dataBase.userDAO().getAllvalid()));
        adbtnhome =findViewById(R.id.adbtnhome);
        adbtnhome.setOnClickListener(view -> {
            Intent intent = new Intent(listeAprouvedMissionActivity.this,AppRoadActivity.class);
            startActivity(intent);
        });
    }
}