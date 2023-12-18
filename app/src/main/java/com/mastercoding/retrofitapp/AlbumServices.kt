package com.mastercoding.retrofitapp

import retrofit2.Response
import retrofit2.http.GET

interface AlbumServices {
    //YOU SHOULD SPECIFY ENDPOINTS OF THE URL
    @GET("/albums")
    suspend fun getAlbums():Response<albums>
}