package com.example.demo2.viewModel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private Context context;
    private Listener listener;

    public interface Listener{
        void onClickGptb2();
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    public MainViewModel(Context context) {
        this.context = context;
    }

    public void onClickGptb2(){
        this.listener.onClickGptb2();
    }
}
