package tn.esprit.sostotoroadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button login ;
    private Button signup ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login);
        signup= findViewById(R.id.signup);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayout, new Login())
                .commit();

        login.setOnClickListener(view -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, new Login())
                    .commit();
        });

        signup.setOnClickListener(view -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, new Inscription())
                    .commit();
        });
    }
}