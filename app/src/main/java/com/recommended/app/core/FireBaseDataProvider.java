package com.recommended.app.core;

import com.recommended.app.network.AsyncListener;

/**
 * Created by Muneesh on 18/10/18.
 */

public interface FireBaseDataProvider {

    void getAllProducts(AsyncListener listener);
/*
    void getRecentProducts();

   void getFavourites();

   void getBrowsHistory();*/

}
