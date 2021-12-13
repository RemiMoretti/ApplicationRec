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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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

                Soiree soiree = new Soiree(orga,adresse,ville,cp,date,heure,description,alcool,ouvert);

                String CreaSoiree = soiree.toString();

                String Contenu =  this.readFromFile(getContext());
                int LenContenu = Contenu.length();
                Contenu.substring(0,LenContenu-3);
                Log.i("Crea","Contenu "+Contenu);


                Log.i("Crea","String retournee du fichier : "+Contenu);
                this.writeToFile(Contenu.substring(0,LenContenu-2)+","+CreaSoiree,getContext());
                Log.i("Crea","String crea soirée : "+CreaSoiree);
                String ContenuApresCrea =  this.readFromFile(getContext());
                Log.i("Crea","String retournee du fichier apres la création : "+ContenuApresCrea);




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
            private String readFromFile(Context context) {

                String ret = "";

                try {
                    InputStream inputStream = context.openFileInput("donnees.json");

                    if ( inputStream != null ) {
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String receiveString = "";
                        StringBuilder stringBuilder = new StringBuilder();

                        while ((receiveString = bufferedReader.readLine()) != null ) {
                            stringBuilder.append(receiveString);
                        }

                        inputStream.close();
                        ret = stringBuilder.toString();
                    }
                }
                catch (FileNotFoundException e) {
                    Log.e("login activity", "File not found: " + e.toString());
                } catch (IOException e) {
                    Log.e("login activity", "Can not read file: " + e.toString());
                }

                return ret;
            }
            private void writeToFile(String data,Context context) {
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("donnees.json", Context.MODE_PRIVATE));
                    outputStreamWriter.write(data+"]}");
                    outputStreamWriter.close();
                }
                catch (IOException e) {
                    Log.e("Exception", "File write failed: " + e.toString());
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}