package com.ctproject.caridosenug.Models;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by farhan on 2/29/16.
 */
public interface RestAPI{

    @GET("api")
    Call<Model> loadListDosen();
}