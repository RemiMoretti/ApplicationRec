package com.example.myrecc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrecc.databinding.FragmentDetailSoireeBinding;
import com.example.myrecc.metier.Soiree;

public class DetailSoireeFragment extends Fragment {
    private FragmentDetailSoireeBinding binding;

    //Declaration des variables EditText
    private TextView tvDescSoiree, tvDescCreateur, tvParticipants;
    private ImageView imView;
    private String SDesc;
    private String SVille;
    private String SAdresse;
    private String SPrenom;
    private String SNom;
    private String SDate;
    private String SHeure;
    private String SAlcool;
    private String SOuvert;

    private int ouvert, alcool;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentDetailSoireeBinding.inflate(inflater, container, false);
        Bundle bundle = this.getArguments();


        if(bundle != null){
            Log.i("Crea","TVdescription :  "+bundle.getString("tvDescription"));
            Log.i("Crea","tvVille :  "+bundle.getString("tvVille"));
            Log.i("Crea","tvAdresse :  "+bundle.getString("tvAdresse"));
            Log.i("Crea","prenomOrga :  "+bundle.getString("prenomOrga"));
            Log.i("Crea","nomOrga :  "+bundle.getString("nomOrga"));

            SDesc = bundle.getString("tvDescription");
            SVille = bundle.getString("tvVille");
            SAdresse = bundle.getString("tvAdresse");
            SPrenom = bundle.getString("prenomOrga");
            SNom = bundle.getString("nomOrga");
            SHeure = bundle.getString("tvHeure");
            SDate = bundle.getString("tvDate");
            alcool = bundle.getInt("tvAlcool");
            ouvert = bundle.getInt("tvOuvert");

            if(ouvert == 1 ){
                SOuvert = "Oui";
            }else if(ouvert ==0){
                SOuvert= "non";
            }
            if(alcool == 1 ){
                SAlcool = "Oui";
            }else if(alcool ==0){
                SAlcool= "non";
            }


            binding.tvDescSoiree.setText("Description de la soirée : \n"+SDesc);
            binding.tvDescCreateur.setText("Prénom de l'organisateur : "+SPrenom+"\nNom de l'organisateur : "+ SNom);
            binding.tvParticipants.setText("Date     : " +SDate+
                    "\nHeure  : "+SHeure+
                    "\nVille  : " +SVille+
                    "\nAdresse: "+SAdresse+
                    "\nAlcool : "+SAlcool+
                    "\nSoirée ouverte : "+SOuvert);
            Log.i("Crea","Nom : "+ SNom+"Prenom : " +SPrenom+"/Adresse : " +SAdresse+"/Ville : "+SVille+"/Description : "+SDesc);

        }
        else{
            Log.i("Crea","Rien dans le bundle");
        }

        binding.btRetourMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< Updated upstream
                Intent retour = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(retour);
=======
                NavHostFragment.findNavController(DetailSoireeFragment.this).navigate(R.id.rechercheUneSoiree);
                //Intent retour = new Intent(view.getContext(), MainActivity.class);
                //view.getContext().startActivity(retour);
>>>>>>> Stashed changes
            }
        });

        return binding.getRoot();
//        return viewRoot;
    }

    public void affichage(){
        Log.i("affiche soiree", "appel affichage");
        Log.i("affiche desc", "valeur desc ");
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

<<<<<<< Updated upstream
=======
        //C'est ici qu'on va modifier les TextView
        /*binding.tvDescSoiree.setText("Bonjour je suis monsieur TextView qui annonce la description de la soirée");
        binding.tvDescCreateur.setText("Bonjour je suis monsieur TextView qui annonce la description du créateur");
        binding.tvParticipants.setText("Bonjour je suis monsieur TextView qui annonce la liste des participants");*/

>>>>>>> Stashed changes
        binding.btRetourMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.rechercheUneSoiree);
                //Intent retour = new Intent(view.getContext(), MainActivity.class);
                //view.getContext().startActivity(retour);
            }
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void createdOnView(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove lesSoirees(extras().get("position"));
                getArguments().getInt("position");
            }
        });
    }



}
