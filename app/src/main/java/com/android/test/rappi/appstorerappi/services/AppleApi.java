package com.android.test.rappi.appstorerappi.services;


import com.android.test.rappi.appstorerappi.Models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AppleApi {
    @GET("rss/topfreeapplications/limit={limit}/json")
    Call<Result> listFeeds(@Path("limit") String limit);
}
