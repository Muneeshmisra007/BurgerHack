package com.recommended.app.core;

import java.util.List;

import com.recommended.app.model.Product;
import com.recommended.app.network.AysncListener;

/**
 * Created by Muneesh on 18/10/18.
 */

public interface FireBaseDataProvider {

    void getAllProducts(AysncListener listener);
/*
    void getRecentProducts();

   void getFavourites();

   void getBrowsHistory();*/

}
