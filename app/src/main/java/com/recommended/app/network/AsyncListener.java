package com.recommended.app.network;

import java.util.List;

/**
 * Created by Muneesh on 18/10/18.
 */

public interface AsyncListener<T> {
    void onResponse(Exception exception, T response);
}
