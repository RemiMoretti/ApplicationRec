package com.example.myrecc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myrecc.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button valider = view.findViewById(R.id.btnValid);
        EditText recherche = view.findViewById(R.id.edRecherche);

        valider.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               String ville = recherche.getText().toString();
                Intent search = new Intent(v.getContext(), MainActivity.class);
                Log.i("intent extra ville", "valeur de recherche = "+ville);
                search.putExtra("ville", ville);
                v.getContext().startActivity(search);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}