
package com.poul.android.test.presentation.activity

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.ParseException
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.poul.android.test.R
import com.poul.android.test.reciver.ConnectivityReceiver
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_list.*
import java.text.SimpleDateFormat
import java.util.Date


class MainActivity : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {

  // Private properties
  private val navController by lazy { findNavController(R.id.nav_host_fragment) }
  private val appBarConfiguration by lazy { AppBarConfiguration(topLevelDestinationIds = setOf(R.id.postsListFragment, R.id.favoritesFragment)) }

  override fun onCreate(savedInstanceState: Bundle?) {
    // Switch to AppTheme for displaying the activity
    setTheme(R.style.AppTheme)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setupBottomNavigationBar()
    registerReceiver(ConnectivityReceiver(), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
  }

  override fun onSupportNavigateUp(): Boolean {
    return navController
        .navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
  }

  private fun setupBottomNavigationBar() {
    bottom_navigation.setupWithNavController(navController)
  }

  override fun onNetworkConnectionChanged(isConnected: Boolean) {
    showNetworkMessage(isConnected)
  }

  override fun onResume() {
    super.onResume()
    ConnectivityReceiver.connectivityReceiverListener = this
  }


  private fun showNetworkMessage(isConnected: Boolean) {
    if (!isConnected) {
      layout_network_error.visibility = View.VISIBLE
      recycler_view.visibility = View.GONE
    } else {
      layout_network_error.visibility = View.GONE
      recycler_view.visibility = View.VISIBLE
    }
  }
}
