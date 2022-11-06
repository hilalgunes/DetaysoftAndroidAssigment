package com.example.myapplication.data

import com.google.gson.annotations.SerializedName
//Web servisten json döndüğü için bu jsonlar kullanılabilmek için bir classa pars edildi
data class Todo(
    @SerializedName("UserId")
    val UserId : Int?,
    @SerializedName("id")
    val id : Int?,
    @SerializedName("title")
    val title : String?,
    @SerializedName("completed")
    val completed : Boolean?
)