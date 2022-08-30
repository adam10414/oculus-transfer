package com.adam.oculustransfer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.adam.oculustransfer.databinding.ActivityMainBinding
import com.adam.oculustransfer.http.startServer
import com.adam.oculustransfer.laninfo.LANinfo

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        val lanInfo = LANinfo()
        val linkAddresses = lanInfo.getLinkAddresses(this)
        lanInfo.getIPv4Addresses(linkAddresses)

        binding.lanInfo = lanInfo

//        startServer()
    }
}