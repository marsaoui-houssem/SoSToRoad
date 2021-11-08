package tn.esprit.sostotoroadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import tn.esprit.sostotoroadapp.database.AppDataBase;


public class DetailsActivity extends AppCompatActivity {
        private TextView namedt;
        private TextView emaildt;
        private TextView phonedt;
        private TextView prix;
        private Button sosdt;

        private AppDataBase dataBase;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_details);
            namedt = findViewById(R.id.namedt);
            emaildt = findViewById(R.id.emaildt);
            phonedt = findViewById(R.id.phonedt);
            prix = findViewById(R.id.prix);
            sosdt = findViewById(R.id.sosdt);
            int id = getIntent().getIntExtra("id", 0);
            String name = getIntent().getStringExtra("nameA");
            String email = getIntent().getStringExtra("emailA");
            String phone = getIntent().getStringExtra("phoneA");

            namedt.setText(id + "\n" + name);
            emaildt.setText(id + "\n" + email);
            phonedt.setText(id + "\n" + phone);
            dataBase = AppDataBase.getAppDataBAse(this);
            sosdt.setOnClickListener(view ->
                    dataBase.userDAO().updatefave(id)
            );

        }
}