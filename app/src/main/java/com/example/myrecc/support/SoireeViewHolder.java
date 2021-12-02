package com.example.myrecc.support;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecc.DetailSoiree;
import com.example.myrecc.MainActivity;
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

        Context context = v.getContext();
        Intent data = new Intent(context, DetailSoiree.class);

        data.putExtra("tvAdresse",tvAdresse.getText().toString());
        data.putExtra("tvVille",tvVille.getText().toString());
        data.putExtra("tvDescription",tvDescription.getText().toString());
        data.putExtra("tvHeure",tvHeure.getText().toString());

        Log.i("dataAdresse","data->"+data);

        context.startActivity(data);
        Log.i("context", context.toString());
        }

}
