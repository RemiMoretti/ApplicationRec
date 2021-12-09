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

import com.example.myrecc.databinding.FragmentDetailSoireeBinding;
import com.example.myrecc.metier.Soiree;

public class DetailSoireeFragment extends Fragment {
    private FragmentDetailSoireeBinding binding;

    //Declaration des variables EditText
    private TextView tvDescSoiree;
    private TextView tvDescCreateur;
    private TextView tvParticipants;
    private ImageView imView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentDetailSoireeBinding.inflate(inflater, container, false);
        //View viewRoot = inflater.inflate(R.layout.fragment_detail_soiree, container, true);
        if(getArguments() != null){
            if(getArguments().getString("desc")!=null){
                Log.i("args", "JE SUIS PASSER DANS LA MODIF DE DESC");
                Log.i("args", "getArguments().getString(\"desc\") = "+getArguments().getString("desc"));
                Log.i("args", "valeur du tvDescSoiree = "+ binding.tvDescSoiree);
                binding.tvDescSoiree.setText(getArguments().getString("desc"));
                binding.tvDescCreateur.setText("créateur original avec beaucoup de talents");
            }
        }
        else{
            Log.i("arguments", "getArguments() = "+getArguments());
            binding.tvDescSoiree.setText("Bonjour je suis monsieur TextView qui annonce la description de la soirée");
            binding.tvDescCreateur.setText("Bonjour je suis monsieur TextView qui annonce la description du créateur");
            binding.tvParticipants.setText("Bonjour je suis monsieur TextView qui annonce la liste des participants");
        }



        binding.btRetourMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NavHostFragment.findNavController(DetailSoireeFragment.this).navigate(R.id.action_Detail_to_FirstFragment);
                Intent retour = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(retour);
            }
        });

        /*Bundle bundle = this.getArguments();
        String desc = bundle.getString("tvDescription");
        binding.tvDescSoiree.setText(desc);
        Log.i("Crea","Le bundle : "+bundle);*/

        return binding.getRoot();
        //return viewRoot;
    }

    public void affichage(){
        Log.i("affiche soiree", "appel affichage");
        Log.i("affiche desc", "valeur desc ");
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //C'est ici qu'on va modifier les TextView
        /*binding.tvDescSoiree.setText("Bonjour je suis monsieur TextView qui annonce la description de la soirée");
        binding.tvDescCreateur.setText("Bonjour je suis monsieur TextView qui annonce la description du créateur");
        binding.tvParticipants.setText("Bonjour je suis monsieur TextView qui annonce la liste des participants");*/

        binding.btRetourMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NavHostFragment.findNavController(DetailSoireeFragment.this).navigate(R.id.action_Detail_to_FirstFragment);
                Intent retour = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(retour);
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
