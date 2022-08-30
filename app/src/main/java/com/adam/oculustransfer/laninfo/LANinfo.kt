package com.adam.oculustransfer.laninfo

import android.content.Context
import android.net.ConnectivityManager
import android.net.LinkAddress
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.net.Inet4Address


// A class to collect necessary LAN information to support clients.
class LANinfo() : ViewModel() {
    private val TAG = "LANInfo"
    private var _linkAddresses = MutableLiveData<MutableList<LinkAddress>>()
    private var _ipv4Addresses = MutableLiveData<MutableList<String>>()

    val linkAddresses: LiveData<MutableList<LinkAddress>>
        get() = _linkAddresses

    val ipv4Addresses: LiveData<MutableList<String>>
        get() = _ipv4Addresses

    init {
        _linkAddresses.value = mutableListOf()
        _ipv4Addresses.value = mutableListOf()

    }

    //    Sets the LinkAddress properties of this class.
    fun getLinkAddresses(context: Context): MutableList<LinkAddress> {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager

        _linkAddresses.value =
            connectivityManager?.getLinkProperties(connectivityManager.activeNetwork)?.linkAddresses as MutableList<LinkAddress>
        return _linkAddresses.value as MutableList<LinkAddress>
    }

    //    Sets the IPv4 addresses of this class.
    fun getIPv4Addresses(linkAddresses: MutableList<LinkAddress>): MutableList<String> {

        return if (linkAddresses != null) {
            for (address in linkAddresses) {
                val isV4: Inet4Address? = address.address as? Inet4Address

                if (isV4 != null) {
                    //                Dropping the first char because it's a '/'
                    _ipv4Addresses.value?.add(address.address.toString().drop(1))
                }
            }

            _ipv4Addresses.value!!
        } else {
            _ipv4Addresses.value = mutableListOf()
            mutableListOf()
        }

    }

}