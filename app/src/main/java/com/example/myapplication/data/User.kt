package com.example.myapplication.data


import com.google.gson.annotations.SerializedName
//Web servisten json döndüğü için bu jsonlar kullanılabilmek için bir classa pars edildi
data class User(
    @SerializedName("results")
    val results: List<Result?>?
) {

    data class Result(

        @SerializedName("email")
        val email: String?,

        @SerializedName("gender")
        val gender: String?,

        @SerializedName("name")
        val name: Name?,

        @SerializedName("picture")
        val picture: Picture?,
    ) {

        data class Name(
            @SerializedName("first")
            val first: String?,
            @SerializedName("last")
            val last: String?,
            @SerializedName("title")
            val title: String?
        )

        data class Picture(
            @SerializedName("large")
            val large: String?,
            @SerializedName("medium")
            val medium: String?,
            @SerializedName("thumbnail")
            val thumbnail: String?
        )
    }
}