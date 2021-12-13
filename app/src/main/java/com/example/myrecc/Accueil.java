package com.example.myrecc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrecc.databinding.AccueilBinding;
import com.example.myrecc.databinding.FragmentFirstBinding;



public class Accueil extends Fragment {

    private AccueilBinding binding;

    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = AccueilBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*binding.btCreer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavHostFragment.findNavController(Accueil.this).navigate(R.id.creerUneSoiree);
                    }
                }
        );

        binding.btRecherche.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavHostFragment.findNavController(Accueil.this).navigate(R.id.rechercheUneSoiree);
                    }
                });*/
    }
}
