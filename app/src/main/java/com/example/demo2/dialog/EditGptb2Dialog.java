package com.example.demo2.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

import com.example.demo2.databinding.DialogEditPtb2Binding;
import com.example.demo2.model.HeSo;
import com.example.demo2.viewModel.Gptb2ViewModel;

public class EditGptb2Dialog extends Dialog {


    public EditGptb2Dialog(@NonNull Context context, Gptb2ViewModel viewModel, LifecycleOwner lifecycleOwner) {
        super(context);
        DialogEditPtb2Binding binding = DialogEditPtb2Binding.inflate(LayoutInflater.from(getContext()));
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);

        HeSo heSo = new HeSo();
        viewModel.prarmA.observe(lifecycleOwner, heSo::setA);
        viewModel.prarmB.observe(lifecycleOwner, heSo::setB);
        viewModel.prarmC.observe(lifecycleOwner, heSo::setC);

        binding.btnKq.setOnClickListener(view -> {
            viewModel.data.setValue(heSo);
            this.dismiss();
        });

        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }
}
