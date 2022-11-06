package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.squareup.picasso.Picasso

class LaunchActivity : AppCompatActivity() {

    private lateinit var welcomeImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        //Picasso kütüphanesi kullanılarak resim eklemesi yapılır
        welcomeImageView = findViewById(R.id.welcomeImageView);
        Picasso.get().load("https://logowik.com/content/uploads/images/letter-v-logo-template1570.jpg").into(welcomeImageView);

        val button=findViewById<Button>(R.id.nextButton)

        //Giriş ekranında butona tıklandığında ne yapması gerektiği açıklanır.
        button.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}