package com.memksim.chickagogallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.memksim.chickagogallery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }

}