package com.example.sampleapplication01.ui.temp_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.sampleapplication01.R
import com.example.sampleapplication01.ui.dashboard.DashboardViewModel

class FragmentTemp : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // レイアウトをインフレート
        val root = inflater.inflate(R.layout.fragment_temp, container, false)

        // ViewModelの設定
        //val dashboardViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        //val textView: TextView = root.findViewById(R.id.textView)


        // ボタンの設定
        val buttonBrowser: Button = root.findViewById(R.id.button_return)
        buttonBrowser.setOnClickListener {
            // NavController を使って遷移
            val navController: NavController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main)
            navController.navigate(R.id.navigation_dashboard)
        }

        return root
    }
}
