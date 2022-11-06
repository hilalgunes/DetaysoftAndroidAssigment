package com.example.myapplication.retrofit

import com.example.myapplication.USER_URL
import com.example.myapplication.data.Todo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    //Retrofit nesnesi getInstance isminde bir metod içerisinde object tipinde bir class altında tanımlanır

    fun getInstance(): WebServices {
         val retrofit = Retrofit.Builder()
            .baseUrl(USER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        //retrofit nesnesine bir interface gönderilir
        return retrofit.create(WebServices::class.java)
    }
}