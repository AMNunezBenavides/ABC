package com.example.abc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class PrestamoActivity extends AppCompatActivity {
    Button button;
    EditText id_libro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamo);

        button= findViewById(R.id.button_dev);
        id_libro=findViewById(R.id.id_libro_dev);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator= new IntentIntegrator(PrestamoActivity.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Lector - CDP");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(true);
                integrator.initiateScan();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result= IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (result != null) {
            if(result.getContents()==null){
                Toast.makeText(this,"Lectora cancelada", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,result.getContents(), Toast.LENGTH_LONG).show();
                id_libro.setText(result.getContents());

            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}