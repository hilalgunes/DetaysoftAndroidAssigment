package com.example.myapplication.retrofit

import com.example.myapplication.data.Todo
import com.example.myapplication.data.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface WebServices {
//Interface oluşturulup içerisinde istek methodu ve url'in string tipinde olduğu bilirtilir
    @GET
    fun getRandomUser(@Url serviceUrl: String): Call<User>

    @GET
    fun getTodoList(@Url serviceUrl: String): Call<List<Todo>>

}