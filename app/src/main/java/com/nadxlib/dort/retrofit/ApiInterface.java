package com.nadxlib.dort.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("place/nearbysearch/json?")
    Call<PlacesResponse.Root> searchNearby(@Query("location") String location, @Query(value = "radius", encoded = true) long radius, @Query("type") String type, @Query(value = "key", encoded = true) String key);
}
