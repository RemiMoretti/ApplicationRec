package com.example.myrecc;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.myrecc.metier.CompteUtilisateur;
import com.example.myrecc.metier.Soiree;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrecc.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);



        binding.btCreaSoiree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompteUtilisateur orga  = new CompteUtilisateur("Pesquet","Thomas",50,"rue spatial",17000,"thomas@nasa.com","toto"	,"123");


                String description = binding.etDescription.getText().toString();
                String heure = binding.etHeure.getText().toString();
                String date = binding.etDate.getText().toString();
                String adresse = binding.etAdresse.getText().toString();
                String ville = binding.etVille.getText().toString();
                int cp = Integer.parseInt(binding.etCP.getText().toString());

                RadioGroup radioAlcool = binding.rgAlcool;
                RadioGroup radioOuvert = binding.rgOuvert;
                    int ouvert = radioAlcool.getCheckedRadioButtonId();
                    int Alcool = radioOuvert.getCheckedRadioButtonId();
               if(radioAlcool.getCheckedRadioButtonId() == binding.rbAlcoolOui.getId()) {
                    Alcool=1;
                    Log.i("CreaSoi","Alcool 1 : "+Alcool);
                }else if(radioAlcool.getCheckedRadioButtonId() == binding.rbAlcoolNon.getId()) {
                    Alcool=0;
                    Log.i("CreaSoi","Alcool 0 : "+Alcool);
                }
                if(radioOuvert.getCheckedRadioButtonId() == binding.rbOuvertOui.getId()) {
                    ouvert=1;
                    Log.i("CreaSoi","Ouvert 1 : "+Alcool);
                }else if(radioOuvert.getCheckedRadioButtonId() == binding.rbOuvertNon.getId()) {
                    ouvert=0;
                    Log.i("CreaSoi","Ouvert 0 :"+ouvert);
                }
               Log.i("CreaSoireeOuv","ouvert : "+ouvert);
                Log.i("CreaSoireeAlc","alcool : "+Alcool);;




                Soiree soirée = new Soiree(orga,adresse,ville,cp,date,heure,description,Alcool,ouvert);
                Log.i("CreaSoiree","soirée : "+soirée);

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