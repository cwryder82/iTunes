package com.mac.chris.itunes.retrofit;

import android.os.AsyncTask;

import com.mac.chris.itunes.pojos.Result;
import com.mac.chris.itunes.pojos.Results;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chris on 4/1/16.
 */
public class RetrofitHelper extends AsyncTask<String,Void,List<Result>>{

    final static String BASE_URL = "https://itunes.apple.com/";
    String query;

    public RetrofitHelper(String search) {
        query = search;
    }

    @Override
    protected List<Result> doInBackground(String... params) {

        List<Result> response;
        Results results;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ITunesService rfItunes = retrofit.create(ITunesService.class);

        Call<Results> query = rfItunes.listTracks(this.query, 25);

        try {
            results = query.execute().body();
            if (results.getResults().size()>0)
                response = results.getResults();
            else
                response = new ArrayList<>();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            response =  new ArrayList<>();
        }
        return response;
    }
}