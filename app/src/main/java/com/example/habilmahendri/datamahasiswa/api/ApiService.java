package com.example.habilmahendri.datamahasiswa.api;

import com.example.habilmahendri.datamahasiswa.Data;
import com.example.habilmahendri.datamahasiswa.Value;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    //Untuk Post
    @FormUrlEncoded
    @POST("users")
    Call<Value>daftar(
            @Field("name")String name,
            @Field("kelas")String kelas,
            @Field("npm")String npm,
            @Field("alamat")String alamat

    );

    //Untuk Get
    @GET("users")
    Call<List<Data>> getData();



    //Untuk Delete
    @DELETE("users/{id}")
    Call<ResponseBody> deleData(@Path("id") String id);



    //untuk Update
    @FormUrlEncoded
    @PUT("users/{id}")
    Call<ResponseBody> updateData(@Path("id") String id,
                                  @Field("name")String name,
                                  @Field("kelas")String kelas,
                                  @Field("npm")String npm,
                                  @Field("alamat")String alamat);






}