package com.example.demo2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.demo2.R;
import com.example.demo2.databinding.FragmentMainBinding;
import com.example.demo2.viewModel.MainViewModel;

public class MainFragment extends Fragment {

    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, null, false);
        View view = binding.getRoot();
        MainViewModel mainViewModel = new MainViewModel(getActivity());
        binding.setMainViewModel(mainViewModel);
        mainViewModel.setListener(() -> {
            if (this.navController != null){
                this.navController.navigate(R.id.action_mainFragment_to_gptb2Fragment);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.navController = Navigation.findNavController(view);
    }
}