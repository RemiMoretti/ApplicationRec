package com.example.myrecc.support;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecc.R;
import com.example.myrecc.metier.Soiree;

public class SoireeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvAdresse;
    TextView tvVille;
    TextView tvDescription;
    TextView tvHeure;
    public SoireeViewHolder(@NonNull View itemView) {
        super(itemView);
        tvAdresse = (TextView) itemView.findViewById(R.id.tvAdresse);
        tvVille = (TextView) itemView.findViewById(R.id.tvVille);
        tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
        tvHeure = (TextView) itemView.findViewById(R.id.tvHeure);

        tvAdresse.setOnClickListener(this);
    }


    public void remplirHolder(Soiree laSoiree) {
        tvAdresse.setText (laSoiree.getAdresse());
        tvVille.setText(laSoiree.getVille());
        tvDescription.setText(laSoiree.getDescription());
        tvHeure.setText(laSoiree.getHeure());
    }


    @Override
    public void onClick(View v) {

    }

}
