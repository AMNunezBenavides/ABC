package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnPrestamo=findViewById(R.id.btn_Prestamo);
        btnPrestamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent (v.getContext(), PrestamoActivity.class);
                startActivityForResult(a, 0);
            }
        });

        Button btnDevolucion=findViewById(R.id.btn_Devolucion);
        btnDevolucion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                Intent x = new Intent (vw.getContext(), DevolucionActivity.class);
                startActivityForResult(x, 0);
            }
        });


    }

}