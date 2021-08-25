package com.example.projectitanes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        // recuperar variable ingresada
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int paqueteCode = extras.getInt("paqueteCode");
            Toast.makeText(this, "paqueteCode: " + paqueteCode, Toast.LENGTH_SHORT).show();
        }
    }
}
