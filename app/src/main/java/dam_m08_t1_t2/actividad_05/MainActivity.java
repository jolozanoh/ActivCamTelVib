package dam_m08_t1_t2.actividad_05;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


import static android.content.Intent.ACTION_DIAL;

public class MainActivity extends AppCompatActivity {

    Button btVibrar;
    Button btFoto;
    Button btLlamada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btVibrar = (Button) findViewById(R.id.vibrar);
        btFoto = (Button) findViewById(R.id.foto);
        btLlamada = (Button) findViewById(R.id.llamada);

        btVibrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Vibrator vibrador = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrador.vibrate(5000);
            }
        });

        btLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent llamar = new Intent(ACTION_DIAL);
                startActivity(llamar);
            }
        });

        btFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent foto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(foto,0);
            }
        });
    }
}
