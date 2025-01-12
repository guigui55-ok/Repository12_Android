package com.example.sampleapplication01;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static final String PREF_NAME = "SharedPreferencesManagerPrefs";
    private static final String KEY_SHARED_VALUE = "sharedValue";

    private final SharedPreferences sharedPreferences;

    // コンストラクタで SharedPreferences を初期化
    public SharedPreferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    // 値を保存
    public void saveSharedValue(int value) {
        sharedPreferences.edit().putInt(KEY_SHARED_VALUE, value).apply();
    }

    // 値を取得
    public int getSharedValue() {
        return sharedPreferences.getInt(KEY_SHARED_VALUE, 0); // デフォルト値 0
    }
}
