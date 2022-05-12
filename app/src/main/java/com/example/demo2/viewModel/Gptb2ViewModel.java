package com.example.demo2.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demo2.model.HeSo;

public class Gptb2ViewModel extends ViewModel {

    private Listener listener;

    public MutableLiveData<HeSo> data = new MutableLiveData<>();
    public MutableLiveData<String> prarmA = new MutableLiveData<>();
    public MutableLiveData<String> prarmB = new MutableLiveData<>();
    public MutableLiveData<String> prarmC = new MutableLiveData<>();

    public interface Listener{

        void onClickEdit();
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    public void onClickEdit(){
        this.listener.onClickEdit();
    }

}
