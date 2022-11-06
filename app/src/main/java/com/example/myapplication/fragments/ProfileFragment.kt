package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.*
import com.example.myapplication.data.User
import com.example.myapplication.retrofit.RetrofitClient
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfileFragment : Fragment() {

    private lateinit var profileImageView: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var mailTextView: TextView

    private var user : User? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Görünümler bir değişkene atandı
        profileImageView = view.findViewById(R.id.profile_image)
        nameTextView = view.findViewById(R.id.name_text)
        mailTextView = view.findViewById(R.id.mail_text)


        //Kullanıcının oturum açma durumu kontrol koşulu oluşturuldu
        if (user == null) {
            getUser()
        } else {
            loadUserData()
        }
    }

    private fun loadUserData(){
        Picasso.get().load(user?.results?.get(0)?.picture?.large).into(profileImageView)
        val name =  user?.results?.get(0)?.name?.first?.plus(" ").plus(user?.results?.get(0)?.name?.last)
        nameTextView.text = name
        mailTextView.text = user?.results?.get(0)?.email
    }

    private fun getUser() {

        RetrofitClient.getInstance().getRandomUser(USER_URL).enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {

                if (response.body() != null) {
                    user = response.body()
                    loadUserData()
                } else {
                    Toast.makeText(activity, "hata oldu", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(activity, "hata oldu", Toast.LENGTH_LONG).show()
            }
        })
    }
}

