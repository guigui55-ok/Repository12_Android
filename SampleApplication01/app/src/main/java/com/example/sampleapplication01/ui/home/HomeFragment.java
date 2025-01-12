package com.example.sampleapplication01.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sampleapplication01.MainActivity;
import com.example.sampleapplication01.R;
import com.example.sampleapplication01.databinding.FragmentHomeBinding;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        //ボタン処理
        //View view = inflater.inflate(R.layout.fragment_home, container, false);
        //Button buttonMHomeMain = view.findViewById(R.id.home_main_button);
        Button buttonMHomeMain = binding.homeMainButton; // FragmentHomeBindingからボタンを取得
        buttonMHomeMain.setOnClickListener(v -> {

            Log.d("#buttonMHomeMain", "buttonMHomeMain.setOnClickListener");
            MainActivity mainActivity = (MainActivity) getActivity();
            if (mainActivity != null) {
                Log.d("ExampleFragment", "MainActivityのpackageName: " + mainActivity.getPackageName());
            }
            new AlertDialog.Builder(mainActivity) // FragmentではActivityを取得して生成
                    .setTitle("Dialogタイトル")
                    .setMessage("テストメッセージ")
                    .setNegativeButton(
                            "YES!",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO:Yesが押された時の挙動
                                    Log.d("ExampleFragment","Yesが押された時の挙動");
                                }
                            })
                    .show();


        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}