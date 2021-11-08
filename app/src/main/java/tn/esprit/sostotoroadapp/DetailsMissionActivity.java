package tn.esprit.sostotoroadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import tn.esprit.sostotoroadapp.database.AppDataBase;

public class DetailsMissionActivity extends AppCompatActivity {
    private TextView textViewnom;
    private TextView textViewemail;
    private TextView textViewphone;
    private TextView textViewvoiture;
    private TextView textViewetat;
    private Button annulerdd;
    private Button validerdd;
    private AppDataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_mission);
        textViewnom = findViewById(R.id.textViewnom);
        textViewemail = findViewById(R.id.textViewemail);
        textViewphone = findViewById(R.id.textViewphone);
        textViewvoiture = findViewById(R.id.textViewvoiture);
        textViewetat = findViewById(R.id.textViewetat);
        annulerdd = findViewById(R.id.annulerdd);
        validerdd = findViewById(R.id.validerdd);
        int id = getIntent().getIntExtra("id", 0);
        String name = getIntent().getStringExtra("nameA");
        String email = getIntent().getStringExtra("emailA");
        String phone = getIntent().getStringExtra("phoneA");

        textViewnom.setText(id + "\n" + name);
        textViewemail.setText(id + "\n" + email);
        textViewphone.setText(id + "\n" + phone);
        dataBase = AppDataBase.getAppDataBAse(this);
        validerdd.setOnClickListener(view ->
                dataBase.userDAO().updatestat(id)
        );
        annulerdd.setOnClickListener(view -> {
            Intent intent = new Intent(DetailsMissionActivity.this,MainActivity.class);
            startActivity(intent);
        });
    }
}