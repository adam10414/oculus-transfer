package com.adam.oculustransfer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adam.oculustransfer.http.startServer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startServer()
    }
}