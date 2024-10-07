package com.jah.valoracion_hotel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView lblMostrar, lblNumPersonal, lblNumInstalaciones, lblNumServicios, lblNumLimpieza,
    lblNumConfort, lblNumQA, lblNumUbicacion;
    Button btnNueva;
    RatingBar rbarPersonal, rbarInstalaciones, rbarServicios, rbarLimpieza, rbarConfort, rbarQA, rbarUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lblMostrar = findViewById(R.id.lblMostrar);
        lblNumPersonal = findViewById(R.id.lblNumPersonal);
        lblNumInstalaciones = findViewById(R.id.lblNumInstalaciones);
        lblNumServicios = findViewById(R.id.lblNumServicios);
        lblNumLimpieza = findViewById(R.id.lblNumLimpieza);
        lblNumConfort = findViewById(R.id.lblNumConfort);
        lblNumQA = findViewById(R.id.lblNumQA);
        lblNumUbicacion = findViewById(R.id.lblNumUbicacion);
        btnNueva = findViewById(R.id.btnNueva);
        rbarPersonal = findViewById(R.id.rbarPersonal);
        rbarInstalaciones = findViewById(R.id.rbarInstalaciones);
        rbarServicios = findViewById(R.id.rbarServicios);
        rbarLimpieza = findViewById(R.id.rbarLimpieza);
        rbarConfort = findViewById(R.id.rbarConfort);
        rbarQA = findViewById(R.id.rbarQA);
        rbarUbicacion = findViewById(R.id.rbarUbicacion);

        btnNueva.setOnClickListener(view -> nuevaPuntuacion());

        rbarPersonal.setOnRatingBarChangeListener((ratingBar, v, b) ->{
            actualizarEstrella(ratingBar, lblNumPersonal);
            sacarMedia();
        });
        rbarInstalaciones.setOnRatingBarChangeListener((ratingBar, v, b) ->  {
            actualizarEstrella(ratingBar, lblNumInstalaciones);
            sacarMedia();
        });
        rbarServicios.setOnRatingBarChangeListener((ratingBar, v, b) -> {
            actualizarEstrella(ratingBar, lblNumServicios);
            sacarMedia();
        });
        rbarLimpieza.setOnRatingBarChangeListener((ratingBar, v, b) ->  {
            actualizarEstrella(ratingBar, lblNumLimpieza);
            sacarMedia();
        });
        rbarConfort.setOnRatingBarChangeListener((ratingBar, v, b) ->  {
            actualizarEstrella(ratingBar, lblNumConfort);
            sacarMedia();
        });
        rbarQA.setOnRatingBarChangeListener((ratingBar, v, b) -> {
            actualizarEstrella(ratingBar, lblNumQA);
            sacarMedia();
        });
        rbarUbicacion.setOnRatingBarChangeListener((ratingBar, v, b) ->  {
            actualizarEstrella(ratingBar, lblNumUbicacion);
            sacarMedia();
        });




    }

    private void sacarMedia() {
        double media = (double) ((rbarPersonal.getRating() + rbarInstalaciones.getRating() + rbarServicios.getRating() + rbarLimpieza.getRating() + rbarConfort.getRating() + rbarQA.getRating() + rbarUbicacion.getRating()))  / 7;
        lblMostrar.setText("" + media);
    }

    private void actualizarEstrella(RatingBar rbar, TextView modificacion) {

        int valor = (int) rbar.getRating();
        modificacion.setText("" + valor);
    }

    private void nuevaPuntuacion() {
        rbarPersonal.setRating(0);
        rbarInstalaciones.setRating(0);
        rbarServicios.setRating(0);
        rbarLimpieza.setRating(0);
        rbarConfort.setRating(0);
        rbarQA.setRating(0);
        rbarUbicacion.setRating(0);
    }
}