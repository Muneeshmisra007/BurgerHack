package com.recommended.app.network;

import java.util.List;

import com.recommended.app.model.Product;

/**
 * Created by Muneesh on 18/10/18.
 */

public interface AysncListener {
    void onResponse(Exception exception, List<Product> products);
}
