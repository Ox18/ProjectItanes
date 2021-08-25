package com.example.projectitanes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleActivity extends AppCompatActivity {

    private TextView nombreTourTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        nombreTourTextView = findViewById(R.id.nombreTourTextView);
        // recuperar variable ingresada
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int paqueteCode = extras.getInt("paqueteCode");
            String nombreTour = extras.getString("nombreTour");

            nombreTourTextView.setText(nombreTour);

        }
    }
}
