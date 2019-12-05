package com.example.mvp_android;

import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class UserPreferencesImpl implements UserPreferences  {

    protected SharedPreferences mPreferences;

    public UserPreferencesImpl() {
        this.mPreferences = PreferencesProvider.providePreferences();
    }

    @Override
    public boolean isUserLogin() {
        return mPreferences.getBoolean(IS_USER_LOGIN, false);
    }

    @Override
    public void setUserLogin(boolean status) {
        mPreferences.edit().putBoolean(IS_USER_LOGIN, status).apply();
    }

    @Override
    public void addNote(Note note) {

        ArrayList<Note> dbNotes = getNotes();
        dbNotes.add(0, note);

        String noteAsString = new Gson().toJson(dbNotes);
        mPreferences.edit().putString(NOTES_LIST, noteAsString).apply();
    }

    @Override
    public void removeNote(Note note) {

        ArrayList<Note> dbNotes = getNotes();
        for (int i = 0; i < dbNotes.size(); i++) {
            if (dbNotes.get(i).getId() == note.getId()) {
                dbNotes.remove(i);
                break;
            }
        }

        if (dbNotes.size() > 0) {
            String noteAsString = new Gson().toJson(dbNotes);
            mPreferences.edit().putString(NOTES_LIST, noteAsString).apply();
        } else {
            mPreferences.edit().putString(NOTES_LIST, "").apply();
        }
    }

    @Override
    public ArrayList<Note> getNotes() {

        ArrayList<Note> notes = new ArrayList<>();

        String noteListString = mPreferences.getString(NOTES_LIST, "");
        if (!TextUtils.isEmpty(noteListString)) {
            notes = new Gson().fromJson(noteListString, new TypeToken<List<Note>>() {
            }.getType());
        }

        return notes;
    }

    @Override
    public void clearUser() {
        mPreferences.edit()
                .putBoolean(IS_USER_LOGIN, false)
                .putString(NOTES_LIST, "")
                .apply();
    }
}
