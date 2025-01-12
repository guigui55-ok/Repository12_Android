package com.example.sampleapplication01;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sampleapplication01.databinding.ActivityMainBinding;
import android.util.Log;
//import androidx.lifecycle.ViewModelProvider;

import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final String TAG = "MainActivity";

    private SharedViewModel sharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        // AppBarConfiguration に CountUpFragment を追加
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_count_up)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        //val navController = findNavController(R.id.nav_host_fragment_activity_main)
        //navController.navigate(R.id.navigation_count_up);
        Log.d(TAG, "アプリが起動しました");        // CountUpFragment に直接遷移 (オプション)

        //navController.navigate(R.id.navigation_count_up);


        // ViewModelの取得
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        // 値を設定
        //sharedViewModel.setSharedValue(10); //ループする？

        // 値の監視
        // sharedViewModel.getSharedValue().observe(this, value -> {
        //     Log.d(TAG, "Shared value updated: " + value);
        // });

        // 別の場所で値を変更（例）
        //sharedViewModel.setSharedValue(100);
    }

}

