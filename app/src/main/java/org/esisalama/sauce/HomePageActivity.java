package org.esisalama.sauce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        checkSessionActive();

        configurerButtonLProfile();
        configurerButtonAjouter();
        configurerButtonListeTravail();
    }

    private void checkSessionActive() {
        sharedPreferences = getSharedPreferences("session",MODE_PRIVATE);
        boolean sessionActive = sharedPreferences.getBoolean("session_active", true);

        if (!sessionActive) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void configurerButtonListeTravail() {
        Button btnListeTrav = findViewById(R.id.btn_liste_travail);
        btnListeTrav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, ListeTravailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void configurerButtonAjouter() {
        Button btnAjouter = findViewById(R.id.btn_ajout_travail);
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, AjouterTravailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void configurerButtonLProfile() {
        Button btnProfile = findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}/*
        //modifier la session
        session.edit().putInt("session_id", 123);
        session.edit().putBoolean("session_active", true);
        //c'est comme session start(commit) pas vraiment recommender, il faut utiliser apply
        //pour modifier on utilise edit
        session.edit().commit();

        session.edit()
                .putInt("session_id", 124)
                .putBoolean("session_action", true)
                .apply();
        //get est utiliser pour recuperer
        session.getBoolean("session_active", false);*/


