package com.example.myrecc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrecc.databinding.FragmentDetailSoireeBinding;

public class DetailSoireeFragment extends Fragment {
    private FragmentDetailSoireeBinding binding;

    //Declaration des variables EditText
    private TextView tvDescSoiree;
    private TextView tvDescCreateur;
    private TextView tvParticipants;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentDetailSoireeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //C'est ici qu'on va modifier les TextView
        binding.tvDescSoiree.setText("Bonjour je suis monsieur TextView qui annonce la description de la soirée");
        binding.tvDescCreateur.setText("Bonjour je suis monsieur TextView qui annonce la description du créateur");
        binding.tvParticipants.setText("Bonjour je suis monsieur TextView qui annonce la liste des participants");

        

        binding.btRetourMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DetailSoireeFragment.this)
                        .navigate(R.id.rechercheUneSoiree);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
