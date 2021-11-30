package com.example.myrecc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrecc.databinding.FragmentSecondBinding;

import java.lang.reflect.Type;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    //Declaration des Strings
    private String NomSoiree;
    private String TypeSoiree;
    private String Date;
    private String Heure;

    //Declaration des variables EditText / Radio
    private EditText etNomSoiree;
    private EditText etTypeSoiree;
    private EditText etDate;
    private EditText etHeure;

    private RadioGroup Alcool;
    private RadioButton rbAlcoolOui;
    private RadioButton rbAlcoolNon;

    private RadioGroup Ouvert;
    private RadioButton rbOuvertOui;
    private RadioButton rbOuvertNon;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //On récuperes ici les ET / RB

        NomSoiree=binding.etNomSoiree.getText().toString();
        TypeSoiree=binding.etTypeSoiree.getText().toString();
        Date=binding.etDate.getText().toString();
        Heure=binding.etHeure.getText().toString();

        binding.btCreaSoiree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}