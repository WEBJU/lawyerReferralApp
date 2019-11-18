package com.example.lawyerrecommender;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyLawyers extends Application {

    public static final String TAG=MyLawyers.class.getSimpleName();
    private RequestQueue mRequestQueue;
    private static MyLawyers mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    }

    public static synchronized MyLawyers getInstance(){
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        if (mRequestQueue==null){
            mRequestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }
    public <T> void addToRequestQueue(Request<T>  request){
        request.setTag(TAG);
        getRequestQueue().add(request);

    }
    public void cancelPendingRequest(Object tag){
        if (mRequestQueue!=null){
            mRequestQueue.cancelAll(tag);
        }
    }
}
