package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.myapplication.data.User
import com.example.myapplication.fragments.ProfileFragment
import com.example.myapplication.fragments.TodoFragment
import com.example.myapplication.retrofit.RetrofitClient
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private var  bottomNavigation: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileFragment = ProfileFragment()
        val todoFragment = TodoFragment()

        bottomNavigation = findViewById(R.id.bottom_navigation)

        replaceFragment(profileFragment)

        //Menulere tıklandığınada ne yapılacağını tutmak için setOnItemSelectedListener'ı yazıldı
        bottomNavigation?.setOnItemSelectedListener { bottomNavigation

            //When koşulu ile menulere tıklandığında yapılacak işlem yazıldı
            when (it.itemId) {
                R.id.Profile -> {
                    replaceFragment(profileFragment)
                    true
                }
                R.id.ToDo -> {
                    replaceFragment(todoFragment)
                    true
                }
                else -> false
            }
        }
    }

    //Bir fragmentı açmak için replaceFragment methodu yazıldı
      private fun replaceFragment(fragment: Fragment) {

              if (fragment != Fragment()) {
                  val transaction = supportFragmentManager.beginTransaction()
                  transaction.replace(R.id.frame_layout, fragment)
                  transaction.commit()
              }
        }
}


