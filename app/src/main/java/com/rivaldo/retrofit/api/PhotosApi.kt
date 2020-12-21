package com.rivaldo.retrofit.api

import com.rivaldo.retrofit.model.Photo
import io.reactivex.Single
import retrofit2.http.GET
//untuk mendapatkan photo dari api
interface PhotosApi {
    @GET("photos")
    fun getPhotos(): Single<List<Photo>>
}