package com.example.demo2.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.demo2.databinding.FragmentGptb2Binding;
import com.example.demo2.dialog.EditGptb2Dialog;
import com.example.demo2.viewModel.Gptb2ViewModel;

public class Gptb2Fragment extends Fragment {

    private Gptb2ViewModel viewModel;
    private FragmentGptb2Binding binding;

    public  Gptb2Fragment(){
    }

    @NonNull
    public static Gptb2Fragment newInstance(){
        return new Gptb2Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.viewModel = new ViewModelProvider(this).get(Gptb2ViewModel.class);
        this.binding = FragmentGptb2Binding.inflate(inflater, container, false);
        this.binding.setGptb2ViewModel(viewModel);
        return this.binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.viewModel.setListener(() -> {
            EditGptb2Dialog editGptb2Dialog = new EditGptb2Dialog(this.requireContext(), this.viewModel, this);
            editGptb2Dialog.show();
        });

        this.viewModel.data.observe(this.getViewLifecycleOwner(), heSo -> {
            if (heSo == null) {
                return;
            }
            this.binding.edtPt.setText("A = " + heSo.getA() + " B = " + heSo.getB() + " C = " + heSo.getC());
        });

    }
}