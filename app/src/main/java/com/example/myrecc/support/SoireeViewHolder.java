package com.example.myrecc.support;

import android.view.View;
import android.widget.LinearLayout;
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
    LinearLayout item;
    public SoireeViewHolder(@NonNull View itemView) {
        super(itemView);

        item = itemView.findViewById(R.id.item);
        tvAdresse = (TextView) itemView.findViewById(R.id.tvAdresse);
        tvVille = (TextView) itemView.findViewById(R.id.tvVille);
        tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
        tvHeure = (TextView) itemView.findViewById(R.id.tvHeure);

        item.setOnClickListener(this);
    }


    public void remplirHolder(Soiree laSoiree) {
        tvAdresse.setText (laSoiree.getAdresse());
        tvVille.setText(laSoiree.getVille());
        tvDescription.setText(laSoiree.getDescription());
        tvHeure.setText(laSoiree.getHeure());
    }


    @Override
    public void onClick(View v) {
        /*Soiree laSoiree =;
        v.getContext().startActivity();*/
    }

}
