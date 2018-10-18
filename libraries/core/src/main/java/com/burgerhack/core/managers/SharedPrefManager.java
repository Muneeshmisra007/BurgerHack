package com.burgerhack.core.managers;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * A base helper class for managing the {@link SharedPreferences} in an app. Application class should set the preferences name when {@link Application#onCreate()} is called, or default name for the
 * preferences will be used
 */
public class SharedPrefManager {

    /**
     * Preferences name
     */
    private static String prefName = "notesdrivePreferences";

    /**
     * Static instance for the singleton
     */
    private static SharedPrefManager instance;

    /**
     * {@link SharedPreferences} object for manipulations
     */
    private SharedPreferences prefs;

    private SharedPrefManager(Context context) {

        if (prefs != null) {
            throw new IllegalStateException("No two instances of this class can Co-exist");
        }

        prefs = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    /**
     * Sets the file name of the preferences file name
     *
     * @param prefFileName Preferences File Name
     */
    public static void setPreferencesName(String prefFileName) {

        if (prefFileName == null) {
            throw new IllegalArgumentException("Preferences file name cannot be null");
        }

        SharedPrefManager.prefName = prefFileName;
    }

    /**
     * Returns a singleton of {@link SharedPrefManager}
     *
     * @param context Context to use
     * @return {@link SharedPrefManager} instance
     */
    public synchronized static SharedPrefManager getInstance(Context context) {

        if (instance == null) {
            synchronized (SharedPrefManager.class) {
                instance = new SharedPrefManager(context);
            }
        }
        return instance;
    }

    /**
     * Determines if a value is present in the file, given the key name
     *
     * @param key Key to search for
     * @return true if value is present | false if value not present
     */
    public boolean contains(String key) {

        return prefs.contains(key);
    }

    /**
     * Gets a {@link String} saved in {@link SharedPreferences}
     *
     * @param key Key of the value
     * @return value as {@link String} | null if not present
     */
    public String getString(String key) {

        String value = prefs.getString(key, null);
        return value;
    }

    /**
     * Save or replace a String value
     *
     * @param key
     * @param value
     */
    public void setString(String key, String value) {

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Gets a int saved in {@link SharedPreferences}
     *
     * @param key Key of the value
     * @return value as int | zero if value is not present
     */
    public int getInt(String key) {

        int value = prefs.getInt(key, 0);
        return value;
    }

    /**
     * Save or replace an int value
     *
     * @param key
     * @param value
     */
    public void setInt(String key, int value) {

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * Gets a boolean saved in {@link SharedPreferences}
     *
     * @param key          Key of the value
     * @return value as boolean | false if not saved
     */
    public boolean getBoolean(String key) {

        boolean value = prefs.getBoolean(key, false);
        return value;
    }

    /**
     * Save or replace a boolean value
     *
     * @param key
     * @param value
     */
    public void setBoolean(String key, boolean value) {

        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * Gets a long saved in {@link SharedPreferences}
     *
     * @param key Key of the value
     * @return value as long | zero if value is not present
     */
    public long getLong(String key) {

        long value = prefs.getLong(key, 0);
        return value;
    }

    public float getFloat(String key) {

        float value = prefs.getFloat(key, 0f);
        return value;
    }

    /**
     * Save or replace a long value
     *
     * @param key
     * @param value
     */
    public void setLong(String key, long value) {

        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public void setFloat(String key, float value) {

        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    /**
     * Remove a value
     *
     * @param key Key of the value to remove
     */
    public void delete(String key) {

        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * clearing All preferences while the user loggs out
     */
    public void clearAllPreferences() {

        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
    }
}