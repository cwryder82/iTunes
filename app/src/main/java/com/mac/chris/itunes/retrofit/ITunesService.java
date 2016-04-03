package com.mac.chris.itunes.retrofit;

import com.mac.chris.itunes.pojos.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by chris on 4/1/16.
 */
public interface ITunesService {
    @GET("search")
    Call<Results> listTracks(@Query("term") String q, @Query("limit") int limit);
}

