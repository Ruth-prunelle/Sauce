package org.esisalama.sauce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifierProfileActivity extends AppCompatActivity {
    private String motpass = "19NL446";
    private EditText AncienMotdp;
    private String NouveauMdp;
    private EditText NouveauMotdp;
    private String ConfirmerMdp;
    private EditText ConfirmerMotdp;
    private Button ButtonModif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_profile);

        AncienMotdp = findViewById(R.id.Ancien);
        NouveauMotdp = findViewById(R.id.Nouveau);
        ConfirmerMotdp = findViewById(R.id.Confirmer);
        ButtonModif = findViewById(R.id.Modifier);
        modifierMotDePasse();

    }
    private void modifierMotDePasse()
    {
        ButtonModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Amdp, newPass; String Cmdp;
                Amdp = AncienMotdp.getText().toString();
                newPass = NouveauMotdp.getText().toString();
                Cmdp= ConfirmerMotdp.getText().toString();
                if(Amdp.equals(motpass))
                {
                    if(newPass.length() >= 6)
                {
                    if (newPass.equals(Cmdp))
                    {
                        modifierMdp();
                        motpass = newPass;
                    }else

                        Toast.makeText(ModifierProfileActivity.this, "Le mot de passe doit etre le meme", Toast.LENGTH_SHORT).show();
                }else
                        Toast.makeText(ModifierProfileActivity.this, "retaper votre mot de passe avec les valeurs superieur à 6", Toast.LENGTH_SHORT).show();

                }else
                    Toast.makeText(ModifierProfileActivity.this, "L'ancien mot de passe", Toast.LENGTH_SHORT).show();
                }
        });

    }
    private void modifierMdp() {

        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
        finish();
    }

}