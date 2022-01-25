package com.example.kjra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FotoActivityFinal extends AppCompatActivity {

    ImageView bt;
    Button btncamara;
    Button btngaleria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_final);

        bt= (ImageView) findViewById(R.id.imageView);
        btncamara=(Button) findViewById(R.id.button_camara);
        btngaleria=(Button) findViewById(R.id.button_galeria);

        btncamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Btncamara();
            }
        });

        btngaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Btngaleria();
            }
        });
    }

    private void Btncamara() {
        Intent intentCamara= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCamara, 200);
    }

    private void Btngaleria() {
        Intent intentGallery= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intentGallery, 100);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            bt.setImageURI(data.getData());
        }
        if (requestCode == 200 && resultCode == RESULT_OK) {
            bt.setImageBitmap((Bitmap) data.getExtras().get("data"));
        }
    }
}