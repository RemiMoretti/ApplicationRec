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
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecc.DetailSoiree;
import com.example.myrecc.FirstFragment;
import com.example.myrecc.MainActivity;
import com.example.myrecc.R;
import com.example.myrecc.SecondFragment;
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
        Intent data = new Intent(context, MainActivity.class);

        int position = this.getPosition()+1;
        String donnees = tvDescription.getText().toString();

        data.putExtra("detail",donnees);
        data.putExtra("position", position);

        Log.i("dataAdresse","data->"+data.getExtras().get("detail")+" position = "+data.getExtras().get("position").toString());

        context.startActivity(data);
    }


}
