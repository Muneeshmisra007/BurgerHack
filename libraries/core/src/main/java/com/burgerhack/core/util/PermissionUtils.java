package com.burgerhack.core.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

/**
 * Created by Amritpal Singh on 8/29/16.
 */
public class PermissionUtils {

    /**
     * method that will return whether the permission is accepted. By default it is true if the user is using a device below
     * version 23
     *
     * @param permission
     * @return
     */

    public static boolean hasPermission(Context context, String permission) {
        return (ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED);
    }

    public static boolean hasLocationPermission(Context context) {

        return hasPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) || hasPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION);
    }

    public static boolean hasStorageAccessPermission(Context context) {

        return hasPermission(context, android.Manifest.permission.READ_EXTERNAL_STORAGE) || hasPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public static boolean hasPhoneStatePermission(Context context) {

        return hasPermission(context, android.Manifest.permission.READ_PHONE_STATE) || hasPermission(context, android.Manifest.permission.CALL_PHONE);
    }

    public static boolean hasCameraStoragePermissions(Context context) {
        return hasCameraPermission(context) && hasStorageAccessPermission(context);
    }

    public static boolean hasCameraPermission(Context context) {
        return hasPermission(context, android.Manifest.permission.CAMERA);
    }

    public static boolean shouldShowCamaraStorageRationale(Activity context) {
        return ActivityCompat.shouldShowRequestPermissionRationale(context,
                Manifest.permission.CAMERA) || ActivityCompat.shouldShowRequestPermissionRationale(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }
}
