package tn.esprit.sostotoroadapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import tn.esprit.sostotoroadapp.Adapter.MyAdapter;
import tn.esprit.sostotoroadapp.database.AppDataBase;

public class listSoSActivity extends AppCompatActivity {
    private AppDataBase dataBase;
    private RecyclerView recyclerView;
    private Button btnhom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_so_sactivity);
        dataBase = AppDataBase.getAppDataBAse(this);
        recyclerView = findViewById(R.id.recyclerView);
        btnhom =findViewById(R.id.btnhom);
        btnhom.setOnClickListener(view -> {
            Intent intent = new Intent(listSoSActivity.this,AppRoadActivity.class);
            startActivity(intent);
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyAdapter(this,dataBase.userDAO().getAll()));
    }
}