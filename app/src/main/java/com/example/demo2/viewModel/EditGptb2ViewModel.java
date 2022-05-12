package com.example.demo2.viewModel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demo2.model.HeSo;

public class EditGptb2ViewModel extends ViewModel {
    private Context context;
    private Listener listener;
    private String a, b, c;
    private MutableLiveData<HeSo> heSoMutableLiveData;

    public MutableLiveData<String> prarmA = new MutableLiveData<>();
    public MutableLiveData<String> prarmB = new MutableLiveData<>();
    public MutableLiveData<String> prarmC = new MutableLiveData<>();


    public interface Listener{
        void onClickOk();
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    public EditGptb2ViewModel(Context context) {
        this.context = context;
        this.heSoMutableLiveData = new MutableLiveData<>();
        initData();
    }

    private void initData(){
        HeSo heSo = new HeSo(a, b, c);
        heSoMutableLiveData.setValue(heSo);
    }

    public void onClickOk(){
        this.listener.onClickOk();
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public MutableLiveData<HeSo> getHeSoMutableLiveData() {
        return heSoMutableLiveData;
    }
}
