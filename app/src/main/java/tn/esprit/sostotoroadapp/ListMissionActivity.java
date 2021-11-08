package tn.esprit.sostotoroadapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import tn.esprit.sostotoroadapp.Adapter.MyAdapter;
import tn.esprit.sostotoroadapp.database.AppDataBase;

public class ListMissionActivity extends AppCompatActivity {
    private AppDataBase dataBase;
    private RecyclerView recyclerView;
    private Button homeMss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mission);
        dataBase = AppDataBase.getAppDataBAse(this);
        recyclerView = findViewById(R.id.recyclerView3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyAdapter(this,dataBase.userDAO().getAllfave()));
        homeMss =findViewById(R.id.homeMss);
        homeMss.setOnClickListener(view -> {
            Intent intent = new Intent(ListMissionActivity.this,AppRoadActivity.class);
            startActivity(intent);
        });
    }
}