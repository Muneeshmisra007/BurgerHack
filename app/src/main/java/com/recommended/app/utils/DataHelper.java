package com.recommended.app.utils;

import android.content.Context;

import com.recommended.app.network.FireBaseDataProviderImpl;

/**
 * Created by Muneesh on 18/10/18.
 */

public class DataHelper {

    private static DataHelper sInstance;
    FireBaseDataProviderImpl dataProvider = new FireBaseDataProviderImpl();

    public synchronized DataHelper getsInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DataHelper();
        }
        return sInstance;
    }

    private DataHelper() {
    }

    
}
