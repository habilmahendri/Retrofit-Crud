package com.example.habilmahendri.datamahasiswa.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.habilmahendri.datamahasiswa.Data;
import com.example.habilmahendri.datamahasiswa.R;
import com.example.habilmahendri.datamahasiswa.Value;
import com.example.habilmahendri.datamahasiswa.api.ApiService;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Update_Activity extends AppCompatActivity {

    String url = "http://5b17ff05f5c9b7001455131a.mockapi.io/";
    EditText editName,editNpm,editKelas,editAlamat;
    private Button button,buttonHapus;
    //String name,kelas,npm,alamat,id;
    List<Data> userList = null;
    private static final String TAG = "DATA JSON";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_);


        buttonHapus = (Button)findViewById(R.id.buttonhapus);
        button = (Button)findViewById(R.id.buttonup);
        editName = (EditText)findViewById(R.id.update_nama);
        editKelas = (EditText)findViewById(R.id.update_kelas);
        editNpm = (EditText)findViewById(R.id.update_npm);
        editAlamat = (EditText)findViewById(R.id.update_alamat);

        Intent intent = getIntent();
        final String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String kelas = intent.getStringExtra("kelas");
        String npm = intent.getStringExtra("npm");
        String alamat = intent.getStringExtra("alamat");


        editName.setText(name);
        editKelas.setText(kelas);
        editNpm.setText(npm);
        editAlamat.setText(alamat);


        //Update Objeck
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService api = retrofit.create(ApiService.class);
                Call<ResponseBody> call = api.updateData(id,editName.getText().toString(),editKelas.getText().toString(),editNpm.getText().toString(), editAlamat.getText().toString());
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });



        //DELETE OBJECK
        buttonHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService api = retrofit.create(ApiService.class);
                Call<ResponseBody> del  = api.deleData(id);
                del.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.d("Retro", "onResponse");
                        finish();

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                        Log.d("Retro", "onFailure");
                    }
                });
            }
        });
    }
}
