package com.recommended.app.network;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import com.recommended.app.core.FireBaseDataProvider;
import com.recommended.app.model.Product;

/**
 * Created by Muneesh on 18/10/18.
 */

public class FireBaseDataProviderImpl implements FireBaseDataProvider {

    private DatabaseReference getDB() {
        return FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void getAllProducts(final AysncListener listener) {
        Query myTopPostsQuery = getDB().child("Products");
        myTopPostsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Product> list;
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    Log.d("data===", noteDataSnapshot.getValue(Product.class).toString());
                    list = (List<Product>) noteDataSnapshot.getValue(Product.class);
                    listener.onResponse(list == null ? new Exception() : null, list);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("DatabaseError==", databaseError.toString());
                listener.onResponse(new Exception(), null);
            }
        });

    }

}
