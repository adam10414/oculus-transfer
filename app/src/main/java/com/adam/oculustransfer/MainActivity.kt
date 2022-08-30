package com.adam.oculustransfer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.adam.oculustransfer.http.startServer
import com.adam.oculustransfer.laninfo.LANinfo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lanInfo = LANinfo()
        val linkAddresses = lanInfo.getLinkAddresses(this)
        lanInfo.getIPv4Addresses(linkAddresses)


//        startServer()
    }
}