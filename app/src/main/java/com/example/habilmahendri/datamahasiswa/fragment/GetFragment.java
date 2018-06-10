package com.example.habilmahendri.datamahasiswa.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.habilmahendri.datamahasiswa.Data;
import com.example.habilmahendri.datamahasiswa.DataAdapter;
import com.example.habilmahendri.datamahasiswa.R;
import com.example.habilmahendri.datamahasiswa.api.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class GetFragment extends Fragment {

    private LinearLayoutManager layoutManager;
    private  RecyclerView recyclerView;
    private DataAdapter mAdapter;


    List<Data>userList = null;
    private static final String TAG = "DATA JSON";
    public static GetFragment newInstance() {
        GetFragment fragment = new GetFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank,
                container, false);
         //Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.card_recycler_view);

//
//        userList = new ArrayList<>();
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
//        mAdapter = new DataAdapter(getActivity(), userList);
//        recyclerView.setAdapter(mAdapter);
        getUserList();

        return view;
    }


    private void getUserList(){


        try{
            String url = "http://5b17ff05f5c9b7001455131a.mockapi.io/";
            Retrofit retrofit = null;
            if(retrofit == null){
                retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            ApiService service = retrofit.create(ApiService.class);


            Call<List<Data>>call = service.getData();
            call.enqueue(new Callback<List<Data>>() {
                @Override
                public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                    userList = response.body();
                    for(int i = 0; i < userList.size(); i++){
                        Data p = userList.get(i);
                        Log.i(TAG, " Data dari Json : "+ p.getName());
                    }
                    recyclerView.setHasFixedSize(true);
                    layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);
                    mAdapter = new DataAdapter(getActivity(), userList);
                    recyclerView.setAdapter(mAdapter);
                }
                @Override
                public void onFailure(Call<List<Data>> call, Throwable t) {
                }
            });
        }catch (Exception e){
            Log.d("123","asdasd");}
    }

}


