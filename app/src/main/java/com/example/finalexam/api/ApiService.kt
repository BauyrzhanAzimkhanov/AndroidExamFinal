package com.example.finalexam.api

import com.example.finalexam.model.CountryData
import com.example.finalexam.model.Country
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET

interface ApiService {
    @GET("countries")
    fun getCountries(): Call<List<Country>>

    @GET("countries/{country}/")
    fun getCountryDataByID(@Path("country") country: String): Call<CountryData>
//
//
////    @Headers("Cache-Control: max-age=640000", "User-Agent: My-App-Name")
//    @GET("todos/")
//    fun getTodosByUserId(
//        @Query("completed") completed: Boolean,
//        @Query("userId") userId: Int
//    ): Call<List<Todo>>
//
//
//    @FormUrlEncoded
//    @POST("todos/")
//    fun createTodo(
//        @Field("userId") userId: Int,
//        @Field("title") title: String,
//        @Field("completed") completed: Boolean
//    ): Call<Todo>
//
//
//    @GET
//    fun getTodosWithUrl(@Url url: String): Call<List<Todo>>
}