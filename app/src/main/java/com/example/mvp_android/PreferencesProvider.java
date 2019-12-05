package com.example.mvp_android;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesProvider {

    private static String SHARED_PREFERENCES ="mvpPreferences";
    private static SharedPreferences sPreferences;

    public static SharedPreferences providePreferences()
    {
        return sPreferences;
    }

    public static void init(Context context)
    {
        sPreferences = context.getSharedPreferences(SHARED_PREFERENCES,Context.MODE_PRIVATE);
    }
}
