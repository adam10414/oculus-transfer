package com.adam.oculustransfer

import android.content.Context
import android.net.LinkAddress
import android.util.Log
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adam.oculustransfer.laninfo.LANinfo

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class LANInfoInstrumentTest {
    private val TAG = "LANInstrumentTest"
    lateinit var appContext: Context
    lateinit var lanInfo: LANinfo
    lateinit var linkAddresses: MutableList<LinkAddress>

    @Before
    fun setUp() {
        appContext = InstrumentationRegistry.getInstrumentation().targetContext
        lanInfo = LANinfo()
        linkAddresses = lanInfo.getLinkAddresses(appContext)
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        assertEquals("com.adam.oculustransfer", appContext.packageName)
    }

    @Test
    fun getLinkAddresses() {
        assertNotNull(linkAddresses)
        assertNotNull(lanInfo.linkAddresses)
    }

    @Test
    fun getIPv4Addresses() {
        val ipV4Addresses = lanInfo.getIPv4Addresses(linkAddresses)
        Log.d(TAG, "IP Addresses: $ipV4Addresses")

//        TODO: Figure out how to toggle wifi on so you can actually test this...
//        TODO: The commit message should reflect that this test had a bug in it.

        assertTrue(ipV4Addresses.size > 0)
//        onView(withId(R.id.ip_values)).check(matches(withText(ipV4Addresses[0])))

//        TODO: Toggle wifi off and test null states.

    }
}
