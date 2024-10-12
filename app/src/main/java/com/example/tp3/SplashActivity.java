package com.example.tp3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        // Récupérer l'image du spinner
        logo = findViewById(R.id.logo);

        // Créer l'animation de rotation
        logo.animate().rotation(360f).setDuration(2000);

        // 2. Réduction de la taille à 50% (X et Y) en 3 secondes
        logo.animate().scaleX(0.5f).scaleY(0.5f).setDuration(3000);

        // 3. Translation du logo de 1000 unités sur l'axe Y en 2 secondes
        logo.animate().translationYBy(1000f).setDuration(2000);

        // 4. Diminution de l'opacité à 0 (invisibilité) en 6 secondes
        logo.animate().alpha(0f).setDuration(6000);

        // Délai avant de lancer l'activité principale
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                    Intent intent = new Intent(SplashActivity.this, ListActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}


