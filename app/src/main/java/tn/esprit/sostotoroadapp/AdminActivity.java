package tn.esprit.sostotoroadapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import tn.esprit.sostotoroadapp.Adapter.MyAdapter2;
import tn.esprit.sostotoroadapp.database.AppDataBase;

public class AdminActivity extends AppCompatActivity {
    private AppDataBase dataBase;
    private RecyclerView recyclerView;
    private Button homeadmin;
    private Button aprdmiss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        dataBase = AppDataBase.getAppDataBAse(this);
        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyAdapter2(this,dataBase.userDAO().getAllfave()));
        homeadmin =findViewById(R.id.homeadmin);
        homeadmin.setOnClickListener(view -> {
            Intent intent = new Intent(AdminActivity.this,MainActivity.class);
            startActivity(intent);
        });
        aprdmiss =findViewById(R.id.aprdmiss);
        aprdmiss.setOnClickListener(view -> {
            Intent intent = new Intent(AdminActivity.this,listeAprouvedMissionActivity.class);
            startActivity(intent);
        });
    }
}