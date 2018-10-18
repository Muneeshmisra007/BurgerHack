package com.burgerhack.multicycler.modelservices;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Amritpal Singh on 28/09/2016.
 */
public class DataList<E> extends ArrayList<E> {
    private WeakReference<OnDataListUpdateListener> mListener;

    public void setOnDataListUpdateListener(OnDataListUpdateListener listener) {
        mListener = new WeakReference<OnDataListUpdateListener>(listener);
    }

    public void removeOnDataListUpdateListener() {
        if (mListener != null) {
            OnDataListUpdateListener temp = mListener.get();
            if (temp != null) {
                mListener.clear();
                mListener = null;
            }
        }
    }

    private void dataUpdated() {
        if (mListener != null) {
            OnDataListUpdateListener listener = mListener.get();
            if (listener != null) {
                listener.onDataListUpdated();
            }
        }
    }

    @Override
    public boolean add(E object) {
        boolean b = super.add(object);
        dataUpdated();
        return b;
    }

    @Override
    public void add(int index, E object) {
        super.add(index, object);
        dataUpdated();
    }

    @Override
    public boolean addAll(Collection collection) {
        boolean b = super.addAll(collection);
        dataUpdated();
        return b;
    }

    @Override
    public boolean addAll(int index, Collection collection) {
        boolean b = super.addAll(index, collection);
        dataUpdated();
        return b;
    }

    public boolean addAll(Collection collection, boolean refresh) {
        boolean b = super.addAll(0, collection);
        if (refresh) {
            dataUpdated();
        }
        return b;
    }

    @Override
    public boolean remove(Object object) {
        boolean b = super.remove(object);
        dataUpdated();
        return b;
    }

    @Override
    public E remove(int index) {
        E b = super.remove(index);
        dataUpdated();
        return b;
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
        dataUpdated();
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean b = super.removeAll(collection);
        dataUpdated();
        return b;
    }

    @Override
    public void clear() {
        super.clear();
        dataUpdated();
    }

    public void resetWith(Collection collection) {
        super.clear();
        super.addAll(collection);
        dataUpdated();
    }

}
