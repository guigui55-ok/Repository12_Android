package com.example.sampleapplication01.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.sampleapplication01.R;
import com.example.sampleapplication01.databinding.FragmentDashboardBinding;

import android.content.Intent;
import android.net.Uri;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // ボタンの設定
        Button buttonOtherScreen = root.findViewById(R.id.button_other_screen);
        buttonOtherScreen.setOnClickListener(v -> {
            // NavController を使って FragmentTemp に遷移
            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.navigation_temp);
        });
        // ボタンの設定
        Button buttonBrowser = root.findViewById(R.id.button_browser);
        buttonBrowser.setOnClickListener(v -> {

            // ボタンを押したときにURLを開く
            openUrlInBrowser("https://www.google.com");
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * 指定されたURLをブラウザで開く
     *
     * @param url 開きたいURL
     */
    private void openUrlInBrowser(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}
