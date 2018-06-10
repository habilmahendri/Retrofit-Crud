package com.example.habilmahendri.datamahasiswa.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.habilmahendri.datamahasiswa.R;
import com.example.habilmahendri.datamahasiswa.Value;
import com.example.habilmahendri.datamahasiswa.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends Fragment {
        public static PostFragment newInstance() {
        PostFragment fragment = new PostFragment();
        return fragment;
    }

       private EditText editNama,editKelas,editNpm,editAlamat;
       private Button button;




    public static final String ROOT_URL = "http://5b17ff05f5c9b7001455131a.mockapi.io/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment2,
                container, false);
        button = (Button)view.findViewById(R.id.button);
        editNama = (EditText)view.findViewById(R.id.edt_nama);
        editKelas = (EditText)view.findViewById(R.id.edt_kelas);
        editNpm = (EditText)view.findViewById(R.id.edt_npm);
        editAlamat = (EditText)view.findViewById(R.id.edt_alamat);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserData();
            }
        });

        return view;
    }


    private void inserData(){

        String nama = editNama.getText().toString();
        String kelas = editKelas.getText().toString();
        String npm  = editNpm.getText().toString();
        String alamat = editAlamat.getText().toString();


        if((nama.matches("")&&kelas.matches("")&&npm.matches("")&&alamat.matches(""))){
            Toast.makeText(getActivity(), "Isi data dulu", Toast.LENGTH_SHORT).show();
        }else {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ROOT_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService api = retrofit.create(ApiService.class);
            Call<Value> call = api.daftar(nama, kelas, npm, alamat);
            call.enqueue(new Callback<Value>() {
                @Override
                public void onResponse(Call<Value> call, Response<Value> response) {

                }

                @Override
                public void onFailure(Call<Value> call, Throwable t) {

                }
            });
        }
    }




}
