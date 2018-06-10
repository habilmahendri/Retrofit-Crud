package com.example.habilmahendri.datamahasiswa.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.habilmahendri.datamahasiswa.Data;
import com.example.habilmahendri.datamahasiswa.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BiodataActivity extends AppCompatActivity {
    List<Data> userList = null;
    private static final String TAG = "DATA JSON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);
        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("name")){
            String nama = getIntent().getStringExtra("name");
            String npm = getIntent().getStringExtra("npm");
            String kelas = getIntent().getStringExtra("kelas");
            String image = getIntent().getStringExtra("gambar");

            setData(nama,npm,kelas,image);
        }
    }

    private void setData(String nama,String npm,String kelas, String urlImage){
        TextView textView = findViewById(R.id.dataNama);
        textView.setText(nama);

        TextView textView1 = findViewById(R.id.dataNpm);
        textView1.setText(npm);

        TextView textView2 = findViewById(R.id.dataKelas);
        textView2.setText(kelas);

        ImageView imageView = findViewById(R.id.dataImage);
        Glide.with(this)
                .asBitmap()
                .load(urlImage)
                .into(imageView);


    }
}
