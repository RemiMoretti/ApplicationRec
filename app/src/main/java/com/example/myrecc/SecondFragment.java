package com.example.myrecc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.myrecc.metier.CompteUtilisateur;
import com.example.myrecc.metier.Soiree;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrecc.databinding.FragmentSecondBinding;

import org.w3c.dom.Text;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private String description ;
    private String heure;
    private String date;
    private String adresse;
    private String ville;

    private int cp;
    private int ouvert;
    private int alcool;

    private RadioGroup radioalcool;
    private RadioGroup radioOuvert;

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

                if(description==null){
                    description="";
                }
                if(heure==null){
                    heure="";
                }
                if(date==null){
                    date="";
                }
                if(adresse==null){
                    adresse="";
                }
                if(ville==null){
                    ville="";
                }
                ouvert=0;
                alcool=0;

                cp=Integer.parseInt(binding.etCP.getText().toString());
                description = binding.etDescription.getText().toString();
                heure = binding.etHeure.getText().toString();
                date = binding.etDate.getText().toString();
                adresse = binding.etAdresse.getText().toString();
                ville = binding.etVille.getText().toString();
                //    cp = Integer.parseInt(binding.etCP.getText().toString());


                radioalcool = binding.rgAlcool;
                radioOuvert = binding.rgOuvert;
                ouvert = radioalcool.getCheckedRadioButtonId();
                alcool = radioOuvert.getCheckedRadioButtonId();

                if(radioalcool.getCheckedRadioButtonId() == binding.rbAlcoolOui.getId()) {alcool=1;}
                else if(radioalcool.getCheckedRadioButtonId() == binding.rbAlcoolNon.getId()) {alcool=0;}
                if(radioOuvert.getCheckedRadioButtonId() == binding.rbOuvertOui.getId()) {ouvert=1;}
                else if(radioOuvert.getCheckedRadioButtonId() == binding.rbOuvertNon.getId()) {ouvert=0;}

                Soiree soirée = new Soiree(orga,adresse,ville,cp,date,heure,description,alcool,ouvert);



/*
            Bundle dataCreaSoiree = new Bundle();
                dataCreaSoiree.putString("tvAdresse",adresse);
                dataCreaSoiree.putString("tvVille",ville);
                dataCreaSoiree.putString("tvDescription",description);
                dataCreaSoiree.putString("prenomOrga",orga.getNom());
                dataCreaSoiree.putString("nomOrga",orga.getPrenom());
 */




                DetailSoireeFragment fragment = new DetailSoireeFragment();
                Bundle dataCreaSoiree = new Bundle();
                dataCreaSoiree.putString("tvHeure",heure);
                dataCreaSoiree.putString("tvDate",date);
                dataCreaSoiree.putInt("tvAlcool",alcool);
                dataCreaSoiree.putInt("tvOuvert",ouvert);
                dataCreaSoiree.putString("tvAdresse",adresse);
                dataCreaSoiree.putString("tvVille",ville);
                dataCreaSoiree.putString("tvDescription",description);
                dataCreaSoiree.putString("prenomOrga",orga.getNom());
                dataCreaSoiree.putString("nomOrga",orga.getPrenom());
                Log.i("Crea","data du bundle de creation : "+dataCreaSoiree);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragment.setArguments(dataCreaSoiree);
                fragmentTransaction.addToBackStack(null);
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, fragment).commit();

                //NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_SecondFragment_to_detail_Soiree);

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}