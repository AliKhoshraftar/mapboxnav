package com.mapbox.services.android.navigation.v5.navigation;

import com.mapbox.api.directions.v5.models.DirectionsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ali on 2018-01-07.
 */

public interface ShivehDirectionsService {

    @GET("route/v1/driving/{coordinates}")
    Call<DirectionsResponse> getCall(
//            @Header("User-Agent") String userAgent,
//            @Path("user") String user,
//            @Path("profile") String profile,
            @Path("coordinates") String coordinates,
            @Query("alternatives") Boolean alternatives,
            @Query("steps") Boolean steps,
            @Query("overview") String overview
//            @Query("bearings") String bearings,
//            @Query("continue_straight") Boolean continueStraight,
//            @Query("annotations") String annotations,
//            @Query("language") String language,
//            @Query("roundabout_exits") Boolean roundaboutExits,
//            @Query("voice_instructions") Boolean voiceInstructions,
//            @Query("banner_instructions") Boolean bannerInstructions,
//            @Query("voice_units") String voiceUnits,
//            @Query("exclude") String exclude
    );
}
